package org.serdarsenturk.console1;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import static org.serdarsenturk.console1.services.Consumer1.consumeAndSendMessage;
import static org.serdarsenturk.console1.services.Consumer2.consumeAndSendMail;

public class App
{
    public static void main(String[] argv) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();
        String uri = System.getProperty("RABBITMQ_CONN");
        factory.setUri(uri);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("serdarsenturk.rabbitmq.exchange", "direct");
        String queueName = channel.queueDeclare().getQueue();
        String queueName2 = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "serdarsenturk.exchange", "serdarsenturk.routingkey");        channel.queueBind(queueName, "serdarsenturk.exchange", "serdarsenturk.routingkey");
        channel.queueBind(queueName2, "serdarsenturk.exchange", "serdarsenturk.routingkey");

        consumeAndSendMessage(channel, queueName);
        consumeAndSendMail(channel, queueName2);
    }
}
