package se.iths.autofix.jms.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.iths.autofix.jms.config.JmsConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Sender {

    Logger logger = LoggerFactory.getLogger(Sender.class);
    RabbitTemplate rabbitTemplate;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

   // @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        logger.info("Message sent: Hello world");
        rabbitTemplate.convertAndSend("TestQueue", "Hello, world!");

    }

}
