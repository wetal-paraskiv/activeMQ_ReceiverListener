package org.example.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ResourceBundle;

public class ConsumerCatalogApp {


   public static void main(String[] args) throws JMSException {
      final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
      String user = resourceBundle.getString("activemq.user");
      String password = resourceBundle.getString("activemq.password");

      ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//      Connection connection = factory.createConnection();
      Connection connection = factory.createConnection(user, password);
      connection.start();
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Destination destination = session.createQueue("CatalogApp");
      MessageConsumer consumer = session.createConsumer(destination);

      Message message;
      while (true) {
         message = consumer.receive(1000);
         if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println("Received message:\n\t\t"+ new java.util.Date() + "\n\n" + text);
         }
      }
   }
}
