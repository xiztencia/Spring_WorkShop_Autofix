package se.iths.autofix.jms;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import se.iths.autofix.entity.Employee;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

public class JmsMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        Employee employee = (Employee) object;
        MapMessage message = session.createMapMessage();
        message.setString("username", employee.getUsername());
        message.setString("firstname", employee.getFirstname());
        message.setString("lastname", employee.getLastname());
        message.setString("email", employee.getEmail());
        message.setString("password", employee.getPassword());
        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        MapMessage mapMessage = (MapMessage) message;
        return new Employee(mapMessage.getString("username")
                ,mapMessage.getString("firstname")
                ,mapMessage.getString("lastname")
                ,mapMessage.getString("email")
                ,mapMessage.getString("password"));
    }
}
