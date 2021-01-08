package se.iths.autofix.jms.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class JmsConfig {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        if(!(System.getProperty("os.name").equals("Windows 10"))) {
            CachingConnectionFactory factory = new CachingConnectionFactory(System.getenv("RABBIT_BROKER_URL"));
            factory.setPassword(System.getenv("RABBIT_BROKER_PASSWORD"));
            factory.setUsername(System.getenv("RABBIT_BROKER_USERNAME"));
            factory.setVirtualHost(System.getenv("RABBIT_BROKER_VHOST"));
            System.out.println(System.getProperty("os.name"));
            return factory;
        }
        else {
            CachingConnectionFactory factory = new CachingConnectionFactory(System.getProperty("RABBIT_BROKER_URL"));
            factory.setPassword(System.getProperty("RABBIT_BROKER_PASSWORD"));
            factory.setUsername(System.getProperty("RABBIT_BROKER_USERNAME"));
            factory.setVirtualHost(System.getProperty("RABBIT_BROKER_VHOST"));
            return factory;
        }
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }


    @Bean
    public Queue myQueue() {
        return new Queue("TestQueue",false);
    }


}
