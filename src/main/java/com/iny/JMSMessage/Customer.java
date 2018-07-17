package com.iny.JMSMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zcy on 2018/4/9.
 */
public class Customer{
    private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616");
    public static void main(String[] args) throws JMSException {

        final Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(true,Session.SESSION_TRANSACTED);

        Destination destination = session.createQueue("wc-order-create");

        MessageConsumer customer = session.createConsumer(destination);

        customer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textmessage = (TextMessage) message;

                try {
                    System.out.println("customer1 接受消息:"+textmessage.getText());
                    session.commit();
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });
    }


}