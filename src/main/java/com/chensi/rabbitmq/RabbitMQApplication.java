package com.chensi.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMQApplication implements CommandLineRunner{
    @Autowired
    RabbitTemplate rabbitTemplate; //1

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }

    @Bean //2
    public Queue wiselyQueue(){
        return new Queue("my-queue5");
    }


    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend("my-queue5", "来自RabbitMQ的问候"); //3

    }
}
