package se.iths.autofix.jms.sender;

//@Component
//public class Sender {
//
//    JmsTemplate jmsTemplate;
//
//    public Sender(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }
//
//    @Scheduled(fixedRate = 2000)
//    public void sendMessage() {
//
//        System.out.println("Sending message...");
//        MessageObject messageObject = new MessageObject(UUID.randomUUID(), "Hello from JU19_QUEUE!", LocalDateTime.now());
//        jmsTemplate.convertAndSend(JmsConfig.JU19_QUEUE, messageObject);
//        System.out.println("Message sent!");
//
//    }
//
//}
