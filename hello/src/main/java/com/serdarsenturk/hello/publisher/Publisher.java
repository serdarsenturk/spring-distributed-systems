package com.serdarsenturk.hello.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Qualifier("rabbitTemplates")
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${serdarsenturk.rabbitmq.exchange}")
    private String exchange;

    @Value("${serdarsenturk.rabbitmq.routingkey}")
    private String routingKey;

    public void produce(String msg){
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("Send message = **' " + msg);
    }
}