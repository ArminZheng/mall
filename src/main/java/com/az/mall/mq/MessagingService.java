package com.az.mall.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author AZ
 * @since 2021-11-03
 */
@Component
public class MessagingService {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMailMessage() throws Exception {
        String text = "...";
        jmsTemplate.send("jms/queue/mail", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });

        jmsTemplate.send("jms/queue/mail", session -> session.createTextMessage(text));

        // TextMessage：文本消息；
        // BytesMessage：二进制消息；
        // MapMessage：包含多个Key-Value对的消息；
        // ObjectMessage：直接序列化Java对象的消息；
        // StreamMessage：一个包含基本类型序列的消息。
    }
}