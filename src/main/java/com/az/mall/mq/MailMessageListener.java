package com.az.mall.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * @author AZ
 * @since 2021-11-03
 */
@Component
@Slf4j
public class MailMessageListener {

    @JmsListener(destination = "jms/queue/mail", concurrency = "10")
    public void onMailMessageReceived(Message message) throws Exception {
        log.info("received message: " + message);
    }
}
