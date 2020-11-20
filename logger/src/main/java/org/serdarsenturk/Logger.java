package org.serdarsenturk;

import org.apache.log4j.BasicConfigurator;
import org.serdarsenturk.services.MessageLog;
import org.serdarsenturk.services.SendToAdmin;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Logger
{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public static void main( String[] args ) throws URISyntaxException, IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {

//        MessageLog.messageLogger();
//        SendToAdmin.sendToAdmin();

        BasicConfigurator.configure();

        Jedis jedis = new Jedis("localhost", 6379);
        logger.info("Stored data in cache :" + jedis.get("cache#1"));
    }
}
