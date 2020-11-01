package org.serdarsenturk.console1;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.serdarsenturk.console1.services.Consumer1;
import org.serdarsenturk.console1.services.Consumer2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;


public class App
{
    public static void main(String[] argv) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        Consumer1.consumeAndSendMessage();
        Consumer2.consumeAndSendMail();
    }
}
