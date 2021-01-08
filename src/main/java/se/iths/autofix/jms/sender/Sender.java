package se.iths.autofix.jms.sender;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


@Component
public class Sender {

    Logger logger = LoggerFactory.getLogger(Sender.class);
    RabbitTemplate rabbitTemplate;


    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


   // @Scheduled(fixedRate = 2000)
    public void sendMessage(String message,String info) {
        logger.info("Message sent: "+info);
        rabbitTemplate.convertAndSend("TestQueue", message);

    }

}
