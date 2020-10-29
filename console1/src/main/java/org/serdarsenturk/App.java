package org.serdarsenturk;


import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import static org.serdarsenturk.services.consumer1.consumeAndSendMessage;

public class App
{
    public static void main(String[] argv) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        consumeAndSendMessage();
    }
}
