package com.nhnacademy.node;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;
import com.nhnacademy.message.TcpRequestMessage;
import com.nhnacademy.message.TcpResponseMessage;
import lombok.extern.slf4j.Slf4j;
import com.github.f4b6a3.uuid.UuidCreator;

@Slf4j
public class TCPServer extends InputOutputNode {
    static class Handler implements Runnable {

        UUID id;
        Socket socket;
        BufferedInputStream inputStream;
        BufferedOutputStream outputStream;
        byte[] buffer;
        BiConsumer<byte[], Integer> callback;
        TCPServer server;       //이거 질문하기
        Thread thread;

        public Handler(Socket socket, TCPServer server) {
            id = UuidCreator.getTimeBased();
            thread = new Thread(this);
            buffer = new byte[100000];
            this.socket = socket;
            this.server = server;
            
            log.info("Handler생성 id : {}", id);
        }

        public UUID getHandlerId() {
            return id;
        }

        public void setCallback(BiConsumer<byte[], Integer> callback) {
            this.callback = callback;
        }

        public void start() {
            thread.start();
        }

        public void stop() {
            try {
                inputStream.close();
            } catch (IOException e) {
                //
            } finally {
                thread.interrupt();
            }
        }

        public void write(byte[] data) {
            try {
                outputStream.write(data);
                outputStream.flush();

                log.info("Handler {} flush", id);
            } catch (IOException e) {
                log.error("{} {}", getClass().getSimpleName(), e.getMessage());
            }
        }

        //Client의 요청을 outputWire에 put해주는 과정
        //TCPServer의 proccess()안에서 handler.start()가 호출되면 실행
        //socket의 stream들을 열고
        //inputStream을 통해 client의 requset를 받아서 buffer에 저장한 후
        //callback.accept(buffer, length)를 통해 받은 파라미터 두 개의 값을 람다식으로 작성한 로직을 실행 166줄
        //<166줄 안에 보면 OutputWire에 put해주는 것을 볼 수 있다.>
        @Override
        public void run() {
            try {
                inputStream = new BufferedInputStream(socket.getInputStream());
                outputStream = new BufferedOutputStream(socket.getOutputStream());

                while(!Thread.currentThread().isInterrupted()) {
                    int length = inputStream.read(buffer);
                    log.info("RequestMessage Length : {}", length);
                    log.info("RequestMessage Data : {}", new String(buffer));
                    callback.accept(buffer, length);
                }

                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                log.error("{} {}", getClass().getSimpleName(), e.getMessage());
            } finally {
                inputStream = null;
                outputStream = null;
            }
        }
        
    }


    int port = 1234;
    ServerSocket serverSocket;
    Map<UUID, Handler> handlerMap; 
    Thread messageReceiver;

    public TCPServer(String name) {
        super(name, 1, 1);
    }

    Handler getHandler(UUID id) {
        return handlerMap.get(id);
    }

    @Override
    public void preprocess() {
        try {
            serverSocket = new ServerSocket(port);

            //messageReceiver는 inputWire에 들어온 data, 즉 Response를 보낼 최종적인 Messgae data
            //를 받아서 
            //handler.write() 메서드를 통해 socket의 outputStream에 write -> flust하는 과정을 수행
            //client에세 response를 보낸다.
            messageReceiver = new Thread(() -> {

                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        for (int i = 0; i < getInputWireCount(); i++) {
                            if ((getInputWire(i) != null) && getInputWire(i).hasMessage()) {
                                Message message = getInputWire(i).get();
                                if (message instanceof TcpResponseMessage) {
                                    TcpResponseMessage response = (TcpResponseMessage) message;
                                    Handler handler = getHandler(response.getSenderId());

                                    handler.write(response.getPayload());
                                }
                            }
                        }
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            messageReceiver.start();
        } catch (IOException e) {
            log.error("{} {}", getClass().getSimpleName(), e.getMessage());
        }
    }

   
    @Override
    public void process() {
        //socket이 accept되면
        //Handler를 생성해 socket에 관한 정보들과 Handler의 고유한 id를 생성해 저장
        //Handler의 Biconsumer의 람다식을 정의해서 저장
        //Handler Thread를 실행하고
        //Handler Map에 socket연결에 성공한 Handler의 고유한 id와 handler객체 자체를 넣어준다.
        try {
            Socket socket = serverSocket.accept();
            
            Handler handler = new Handler(socket, this);

            handler.setCallback((data, length) -> {
                putMessage(new TcpRequestMessage(handler.getHandlerId(), data, length));
                putMessage(new StringMessage(socket.getInetAddress().getHostAddress()));

                log.info("{}에서 putMessage로 넣어줄 data : {}", getClass().getSimpleName(), new String(data));
                log.info("{}에서 putMessage로 넣어줄 data : {}", getClass().getSimpleName(), socket.getInetAddress().getHostAddress());
            });

            handler.start();

            handlerMap.put(handler.getHandlerId(), handler);

        } catch (Exception e) {
            log.error("{} {}", getClass().getSimpleName(), e.getMessage());
        }
    }

}
