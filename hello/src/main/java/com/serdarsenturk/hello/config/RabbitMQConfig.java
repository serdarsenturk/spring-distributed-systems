package com.serdarsenturk.hello.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${serdarsenturk.rabbitmq.queue}")
    String queueName;

    @Value("${serdarsenturk.rabbitmq.queue2}")
    String queueName2;

    @Value("${serdarsenturk.rabbitmq.queue3}")
    String queueName3;

    @Value("${serdarsenturk.rabbitmq.queue4}")
    String queueName4;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    Queue queue2(){
        return new Queue(queueName2, false);
    }

    @Bean
    Queue queue3(){
        return new Queue(queueName3, false);
    }

    @Bean
    Queue queue4(){
        return new Queue(queueName4, false);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    @Qualifier
    public AmqpTemplate rabbitTemplates(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}