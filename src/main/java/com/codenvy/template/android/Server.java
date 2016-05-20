package com.codenvy.template.android;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server extends Thread {
 
    public static final int SERVERPORT = 4444;
    private boolean running = false;
 
    public Server() 
    {
     
    }
 
    /**
     * Method to send the messages from server to client
     * @param message the message sent by the server
     */

    @Override
    public void run() {
        super.run();
 
        running = true;
 
        try {
            //create a server socket. A server socket waits for requests to come in over the network.
            ServerSocket serverSocket = new ServerSocket(SERVERPORT);
 
            //create client socket... the method accept() listens for a connection to be made to this socket and accepts it.
            Socket client = serverSocket.accept();
 
            try {
                //read the message received from client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
 
                //in this while we wait to receive messages from client (it's an infinite loop)
                //this while it's like a listener for messages
                while (running) 
                {
                    String message = in.readLine();
                  	message = "" + message;
                }
 
            } catch (Exception e) {
                System.out.println("S: Error");
                e.printStackTrace();
            } finally {
                client.close();
                System.out.println("S: Done.");
            }
 
        } catch (Exception e) {
            System.out.println("S: Error");
            e.printStackTrace();
        }
 
    }
 
    //Declare the interface. The method messageReceived(String message) will must be implemented in the ServerBoard
    //class at on startServer button click
    public interface OnMessageReceived 
    {
        public void messageReceived(String message);
    }
 
}
