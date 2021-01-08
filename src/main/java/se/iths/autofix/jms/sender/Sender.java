package se.iths.autofix.jms.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.iths.autofix.jms.config.JmsConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class Sender {

    Logger logger = LoggerFactory.getLogger(Sender.class);
    RabbitTemplate rabbitTemplate;
    private LocalDateTime localDateTime;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        logger.info("Message sent: Hello world");
        rabbitTemplate.convertAndSend("TestQueue", "Det funka!!!"+ localDateTime);

    }

}
