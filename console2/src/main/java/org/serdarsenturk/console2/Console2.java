package org.serdarsenturk.console2;


import org.serdarsenturk.console2.services.MessageLog;
import org.serdarsenturk.console2.services.SendToAdmin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Console2
{
    public static void main( String[] args ) throws URISyntaxException, IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        SendToAdmin.sendToAdmin();
        MessageLog.messageLogger();
    }
}
