package com.moment.myapplication.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.net.Socket;
import java.net.SocketTimeoutException;


public class ChatClient {
    private Socket client = null;
    private BufferedReader buf = null;
    private PrintStream out = null;

    public ChatClient() {
    }

    public void getClient() {
        try {
            client = new Socket("", 7290);
            client.setSoTimeout(10000);
            buf = new BufferedReader(new InputStreamReader(
                    client.getInputStream()
            ));
            out = new PrintStream(client.getOutputStream());
            System.out.println("Started client socket at" +
                    client.getLocalSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String str) throws Exception{
        out.println(str);
        if ("bye".equals(str)) {
            endClient();
        }
        try {
            String echo = buf.readLine();
            System.out.println(echo);
        } catch (SocketTimeoutException e) {
            System.out.println("Time out, no response");
        }
    }

    public void endClient() throws Exception{
        if (client != null) {
            client.close();
        }
    }

}
