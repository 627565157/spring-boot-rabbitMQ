package com.chensi.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "my-queue5")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
