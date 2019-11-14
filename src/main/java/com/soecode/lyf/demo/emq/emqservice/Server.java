package com.soecode.lyf.demo.emq.emqservice;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author 魏文思
 * @date 2019/11/14$ 14:46$
 */
public class Server {

    public static void main(String[] args) {
        String broker = "tcp://localhost:1883";
        String clientId = "JavaSample";
        //Use the memory persistence
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            //初始化和建立连接
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker:" + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            //发布消息
            String topic = "demo/topics";
            String  content  = "Message from  MqttPushlishSample";
            int  qos=2;
            System.out.println("Publish  mesage :"+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic,message);
            System.out.println("Message Publiched");
        } catch (MqttException me) {
            System.out.println("reason" + me.getReasonCode());
            System.out.println("msg" + me.getMessage());
            System.out.println("loc" + me.getLocalizedMessage());
            System.out.println("cause" + me.getCause());
            System.out.println("excep" + me);
            me.printStackTrace();
        }
    }
}
