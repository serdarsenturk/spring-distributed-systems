package org.serdarsenturk;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class App
{
    public static void main(String[] argv) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqps://yrtwpsmn:RppiFqo59jwb0fQchERAtV1QmM6Sd-iT@woodpecker.rmq.cloudamqp.com/yrtwpsmn");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("serdarsenturk.rabbitmq.exchange", "direct");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "serdarsenturk.exchange", "serdarsenturk.routingkey");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

    }
}
