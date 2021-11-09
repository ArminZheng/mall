package com.az.mall.controller;

import com.az.mall.mq.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 秒杀
 *
 * @author AZ
 * @since 2021-11-02
 */
@RestController
public class SeckillSessionController {

    @Autowired
    MessagingService messagingService;

    @GetMapping(value = "/LateSession")
    public String getLateSession() throws Exception {
        messagingService.sendMailMessage();
        return "success";
    }

}
