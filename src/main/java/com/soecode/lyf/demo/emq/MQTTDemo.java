package com.soecode.lyf.demo.emq;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.text.MessageFormat;

/**
 * @author 魏文思
 * @date 2019/11/14$ 14:21$
 */
public class MQTTDemo {
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
            //订阅消息
            String topic = "demo/topics";
            System.out.println("Subscribe to topic:" + topic);
            sampleClient.subscribe(topic);
            //订阅主题之后，设置一个回调实例Mqttcallback，在消息转发过来的时候将调用该实例方法。
            sampleClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {

                }

                //当消息到达的时候处理一些事情
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String theMsg = MessageFormat.format("{0} is arrived for topic {1}.", new String(message.getPayload()), topic);
                    System.out.println(theMsg);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });
            //发布消息
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
