package com.iny.JMSMessage;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zcy on 2018/4/8.
 */
public class Provider {

    public static void main(String[] args)  {
        //jms常见activemq连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616");

        try{
            Connection connection = connectionFactory.createConnection();

            connection.start();

            Session session = connection.createSession(true,Session.SESSION_TRANSACTED);

            Destination destination = session.createQueue("wc-order-create");

            MessageProducer producer = session.createProducer(destination);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            for (int i =1; i<10; i++){
                TextMessage message = session.createTextMessage("1000125,339900,123,45");
                producer.send(message);
                System.out.println("send success");
            }

            session.commit();
            session.close();

            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}


