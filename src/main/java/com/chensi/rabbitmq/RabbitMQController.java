package com.chensi.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chensi 2018/5/2 0002
 */
@RequestMapping("/user")
@RestController
public class RabbitMQController {

    @Autowired
    RabbitTemplate rabbitTemplate; //1

    @RequestMapping("/hello")
    public String helloWorld(@RequestParam String message) {
        rabbitTemplate.convertAndSend("my-queue5", message); //3
        return message;
    }
}
