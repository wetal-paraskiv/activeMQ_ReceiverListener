package org.example.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ProducerTopic implements Runnable {
    private String messageToSend;
    private String destinationQueue;

    public ProducerTopic(String messageToSend, String destinationQueue) {
        this.messageToSend = messageToSend;
        this.destinationQueue = destinationQueue;
    }
    @Override
    public void run() {
        try {
            // Create a connection factory -> create connection -> connection start
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = factory.createConnection();
            connection.start();

            // Create a session which is non-transactional
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // Create Destination queue
            Destination queue = session.createTopic(destinationQueue);
            // Create a producer
            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // insert message
            TextMessage textMessage = session.createTextMessage(messageToSend);
            messageProducer.send(textMessage);

            session.close();
            connection.close();

        } catch (Exception ex) {
            System.out.println("JMS Exception occurred.  Shutting down client.");
        }
    }
}