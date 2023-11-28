/*
 * package com.nhnacademy.multichat;
 * 
 * import java.util.Arrays;
 * 
 * public class Exe {
 * public static void main(String[] args) {
 * String[] tokens = "#A:@B:hello!".trim().split(":");
 * 
 * System.out.println(Arrays.toString(tokens));
 * }
 * }
 * 
 * package com.nhnacademy.broadcastingserver;
 * 
 * import java.io.BufferedReader;
 * import java.io.BufferedWriter;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 * import java.io.OutputStreamWriter;
 * import java.net.ServerSocket;
 * import java.net.Socket;
 * import java.util.LinkedList;
 * import java.util.List;
 * 
 * public class EchoServer extends Thread {
 * static List<EchoServer> serverList = new LinkedList<>();
 * Socket socket;
 * BufferedWriter writer;
 * 
 * public EchoServer(Socket socket) {
 * this.socket = socket;
 * serverList.add(this);
 * }
 * 
 * // 받은 메시지를 outputStream으로 전달
 * public void send(String message) throws IOException {
 * writer.write(message);
 * writer.flush();
 * }
 * 
 * @Override
 * public void run() {
 * try (BufferedReader reader = new BufferedReader(new
 * InputStreamReader(socket.getInputStream()));
 * BufferedWriter writer = new BufferedWriter(new
 * OutputStreamWriter(socket.getOutputStream()));) {
 * this.writer = writer;
 * while (!Thread.currentThread().isInterrupted()) {
 * String line = reader.readLine(); // 메시지를 받아서
 * 
 * 
 * String [] tokens = line.trim().split(":");
 * if (tokens.length > 1) {
 * // 대소문자 구분 X
 * if (tokens[0].equalsIgnoreCase("id")){
 * setName(tokens[1]);
 * } else if (tokens[0].equalsIgnoreCase("who")) {
 * writer.write(getName()+"\n");
 * writer.flush();
 * }
 * }
 * }
 * } catch (IOException ignore) {
 * // TODO: handle exception
 * }
 * 
 * try {
 * socket.close();
 * } catch (IOException ignore) {
 * // TODO: handle exception
 * }
 * }
 * 
 * public static void main(String[] args) {
 * int port = 1234;
 * 
 * try (ServerSocket serverSocket = new ServerSocket(port)) {
 * while (!Thread.currentThread().isInterrupted()) {
 * Socket socket = serverSocket.accept();
 * 
 * EchoServer echoServer = new EchoServer(socket);
 * echoServer.start();
 * 
 * }
 * } catch (IOException e) {
 * // TODO: handle exception
 * }
 * 
 * for (EchoServer server : serverList) {
 * server.interrupt();
 * try {
 * server.join();
 * } catch (InterruptedException ignore) {
 * // TODO: handle exception
 * Thread.currentThread().interrupt();
 * }
 * }
 * }
 * }
 */