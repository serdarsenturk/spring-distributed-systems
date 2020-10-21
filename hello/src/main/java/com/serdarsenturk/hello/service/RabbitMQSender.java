package com.serdarsenturk.hello.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${serdarsenturk.rabbitmq.exchange}")
    private String exchange;

    @Value("${serdarsenturk.rabbitmq.routingkey}")
    private String routingkey;

    public void send(String name) {
        rabbitTemplate.convertAndSend(exchange, routingkey, "HelloThere");
        System.out.println("Send msg = " + name);

    }
}
