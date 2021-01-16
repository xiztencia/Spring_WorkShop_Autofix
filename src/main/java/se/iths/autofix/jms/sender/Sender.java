package se.iths.autofix.jms.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    Logger logger = LoggerFactory.getLogger(Sender.class);
    RabbitTemplate rabbitTemplate;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message,String info) {
        logger.info("Message sent: "+info);
        rabbitTemplate.convertAndSend("TestQueue", message);
    }
}
