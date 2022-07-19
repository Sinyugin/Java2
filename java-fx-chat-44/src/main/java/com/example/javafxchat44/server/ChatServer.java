package com.example.javafxchat44.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private final List<ClientHandler> clients;

    public ChatServer() {
        this.clients = new ArrayList<>();
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(8189);
             AuthService authService = new InMemoryAuthService()) {
            while (true) {
                System.out.println("Ожидаю подключения...");
                final Socket socket = serverSocket.accept();
                new ClientHandler(socket, this, authService);
                System.out.println("Клиент подключен");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public void broadcastNick(String nickTo, String sendMessage, String nick){

        for (ClientHandler client : clients) {      //отсылаем сообщение получателю
            if (nickTo.equals(client.getNick())) {
                client.sendMessage(nick + " : " + sendMessage);
            }
        }

        for (ClientHandler client : clients) {      // отсылает сообщение самому себе
            if (nick.equals(client.getNick())) {
                client.sendMessage(nick + " : " + sendMessage);
            }
        }
    }


    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler client : clients) {
            if (nick.equals(client.getNick())){
                return true;
            }
        }
        return false;
    }

    public void unsubsribe(ClientHandler client) {
        clients.remove(client);
    }
}
