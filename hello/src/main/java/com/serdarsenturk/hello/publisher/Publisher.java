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

    @Value("${serdarsenturk.rabbitmq.queue}")
    private String queue;

    @Value("${serdarsenturk.rabbitmq.queue2}")
    private String queue2;

    @Value("${serdarsenturk.rabbitmq.queue3}")
    private String queue3;

    @Value("${serdarsenturk.rabbitmq.queue4}")
    private String queue4;

    public void produce(String msg){
        amqpTemplate.convertAndSend(queue, msg);
        amqpTemplate.convertAndSend(queue2, msg);
        amqpTemplate.convertAndSend(queue3, msg);
        amqpTemplate.convertAndSend(queue4, msg);

        System.out.println("Send message = **' " + msg);
    }
}