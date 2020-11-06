package org.serdarsenturk.console1.services;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    private static final String TASK_QUEUE_NAME = "serdarsenturk.queue2";

    public static void consumeAndSendMail() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        String host = System.getenv("CONSOLE_RABBITMQ_HOST");
        factory.setHost(host);

        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.basicQos(2);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");

            System.out.println(" Mail sent to '" + message + "'");

            try {
                doWork(message);
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }
    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
