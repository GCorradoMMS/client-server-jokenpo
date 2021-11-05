package com.uam.jokenpo_sd_aps;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public String status;
    public static InetAddress defaultHost;

    public GameClient(String ipAddress) throws UnknownHostException{
       this.status = "Esperando...";
       this.defaultHost = ipAddress.isEmpty() 
               ? InetAddress.getLocalHost() : InetAddress.getByName(ipAddress);
    }
    
    public int clientCommunication(int gameChoice) throws IOException
            , ClassNotFoundException, InterruptedException{
        
        Socket clientSocket = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        clientSocket = new Socket(this.defaultHost, 9876);
        outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        System.out.println("Sending request to Socket Server");
        outputStream.writeObject(""+gameChoice);
        inputStream = new ObjectInputStream(clientSocket.getInputStream());
        String receivedData = inputStream.readObject().toString();
        int opChoice = Integer.parseInt(receivedData);
        inputStream.close();
        outputStream.close();
        return opChoice;
    }
    
}
