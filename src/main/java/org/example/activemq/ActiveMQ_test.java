package org.example.activemq;


public class ActiveMQ_test {

    public static void main(String[] args) throws InterruptedException {
//        Consumer catalogWithGradesLessThenFive = new Consumer("catalogWithGradesLessThenFive");
//        Thread catalogWithGradesLessThenFiverThread = new Thread(catalogWithGradesLessThenFive);
//        catalogWithGradesLessThenFiverThread.start();
//
//        Consumer professor = new Consumer("professor");
//        Thread professorThread = new Thread(professor);
//        professorThread.start();

//        Consumer created = new Consumer("created");
//        Thread createdThread = new Thread(created);
//        createdThread.start();
//
//        Consumer destroyed = new Consumer("destroyed");
//        Thread destroyedThread = new Thread(destroyed);
//        destroyedThread.start();

//        Consumer vetRegister = new Consumer("vetRegister");
//        Thread vetRegisterThread = new Thread(vetRegister);
//        vetRegisterThread.start();

        ProducerTopic topicProducer = new ProducerTopic(
                "Don't be lazy: GO & WORK!!!\n ... message JMS topic-subscribers :)" + new java.util.Date(), "managerAnnouncement");
        Thread topicThread = new Thread(topicProducer);
        topicThread.start();

    }
}