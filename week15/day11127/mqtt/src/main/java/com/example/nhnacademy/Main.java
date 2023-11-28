package com.example.nhnacademy;

import java.util.UUID;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

// node-red
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String publisherId = UUID.randomUUID().toString(); // UUID : 범용 고유 식별자(고유성이 보장되는 id)
        try (IMqttClient client = new MqttClient("tcp://localhost", publisherId)) {
            // com:1883 안붙여도 mqtt는 기본적으로 1883 사용
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10); // 연결을 얼마나 대기할 것인가
            options.setWill("test/will", "Disconnected".getBytes(), 1, true); // retain : 남아서 복원가능
            options.setKeepAliveInterval(1000);
            client.connect(options); // option 주고 연결

            client.publish("test/a/b/c", new MqttMessage("Hello".getBytes())); // 보냄
            client.subscribe("test/a/b/d", (topic, msg) -> {
                System.out.println("Message received : " + topic);
            });

            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(100);
            }
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}