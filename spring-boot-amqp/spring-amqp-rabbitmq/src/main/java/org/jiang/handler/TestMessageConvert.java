package org.jiang.handler;

import org.jiang.model.MyBody;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

public class TestMessageConvert implements MessageConverter {
    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        System.out.println("=======toMessage=========");
        return new Message(object.toString().getBytes(),messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        System.out.println("=======fromMessage=========");
        return new MyBody(message.getBody());
    }

    //@Override
    //public Object fromMessage(Message message) throws MessageConversionException {
    //    System.out.println("=======fromMessage=========");
    //    return new String(message.getBody());
    //}
}
