package com.uam.jokenpo_sd_aps;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    
    public static ServerSocket gameServer;
    public static int defaultPort = 9876;
    public static String status;

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        GameServer.status = status;
    }
    
    public GameServer(){
        this.status = "Faça sua jogada..";
    }

    public int serverCommunication(int playerChoice) throws IOException, ClassNotFoundException {
        System.out.println("escolha host "+playerChoice);
        gameServer = new ServerSocket(defaultPort);
        System.out.println("Esperando jogada do cliente..");
        this.status = "Esperando jogada do cliente..";
        Socket serverSocket = gameServer.accept();
        ObjectInputStream inputStream = new ObjectInputStream(serverSocket.getInputStream());
        String receivedData = (String) inputStream.readObject();
        int opChoice = Integer.parseInt(receivedData.trim());
        ObjectOutputStream outputStream = new ObjectOutputStream(serverSocket.getOutputStream());
        outputStream.writeObject(playerChoice);
        inputStream.close();
        outputStream.close();
        serverSocket.close();
        gameServer.close();
        return opChoice;
    }
   
   
   
}
