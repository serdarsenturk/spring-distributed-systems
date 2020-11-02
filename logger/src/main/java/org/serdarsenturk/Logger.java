package org.serdarsenturk;

import org.serdarsenturk.services.MessageLog;
import org.serdarsenturk.services.SendToAdmin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Logger
{
    public static void main( String[] args ) throws URISyntaxException, IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        MessageLog.messageLogger();
        SendToAdmin.sendToAdmin();
    }
}
