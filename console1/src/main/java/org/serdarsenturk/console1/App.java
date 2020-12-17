package org.serdarsenturk.console1;
import org.apache.log4j.BasicConfigurator;
import org.serdarsenturk.console1.services.Consumer1;
import org.serdarsenturk.console1.services.Consumer2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class App
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] argv) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        Consumer1.consumeAndSendMessage();
        Consumer2.consumeAndSendMail();

        BasicConfigurator.configure(); // This configure to Log4j

        Jedis jedis = new Jedis("localhost", 6379); // Connect to redis server using localhost
        logger.info("Connection Success");

        jedis.set("cache#1", "CacheTry"); // Set string data in redis cache
        logger.info("Cache stored in redis");
    }
}
