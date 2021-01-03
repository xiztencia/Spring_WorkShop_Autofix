package se.iths.autofix.jms;

import org.springframework.jms.core.JmsTemplate;
import se.iths.autofix.entity.Employee;

import javax.jms.*;
import java.util.Map;

public class JmsListener implements MessageListener {

    private JmsTemplate jmsTemplate;
    private Queue queue;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String msg = ((TextMessage) message).getText();
                System.out.println("Received message: " + msg);
                if (msg == null) {
                    throw new IllegalArgumentException("Null value received...");
                }
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public Employee receiveMessage() throws JMSException {
        Map map = (Map) this.jmsTemplate.receiveAndConvert();
        return new Employee((String) map.get("username")
                ,(String) map.get("firstname")
                ,(String) map.get("lastname")
                ,(String) map.get("email")
                ,(String) map.get("password"));
    }
}
