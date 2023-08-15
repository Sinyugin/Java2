package com.example.javafxchat44.server;

import com.example.javafxchat44.Command;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChatServer {

    private final Map<String, ClientHandler> clients;

    public ChatServer() {
        this.clients = new HashMap<>();
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
 //    public void broadcastNick(String nickTo, String sendMessage, String nick) {
//
//        for (ClientHandler client : clients) {      //отсылаем сообщение получателю
//            if (nickTo.equals(client.getNick())) {
//                client.sendMessage(Command.PRIVATE_MESSAGE, sendMessage);
//            }
//        }
//
//        for (ClientHandler client : clients) {      // отсылает сообщение самому себе
//            if (nick.equals(client.getNick())) {
//                client.sendMessage(Command.MESSAGE, sendMessage);
//            }
//        }
//    }


    public void subscribe(ClientHandler client) {
        clients.put(client.getNick(), client);
        broadcastClientsList();
    }

    public boolean isNickBusy(String nick) {
        return clients.get(nick) != null;
    }

    public void unsubsribe(ClientHandler client) {
        clients.remove(client.getNick());
        broadcastClientsList();
    }

    private void broadcastClientsList() {
        final String nicks = clients.values().stream()
                .map(ClientHandler::getNick)
                .collect(Collectors.joining(" "));
        broadcast(Command.CLIENTS, nicks);
    }

    public void broadcast(Command command, String message) {
        for (ClientHandler client : clients.values()) {
            client.sendMessage(command, message);
        }
    }

    public void sendPrivateMessage(ClientHandler from, String nicTo, String message) {
        final ClientHandler clientTo = clients.get(nicTo);
        if (clientTo == null){
            from.sendMessage(Command.ERROR, "Пользователь не авторизован!");
        }
        clientTo.sendMessage(Command.MESSAGE, "От " + from.getNick() + ": " + message);
        from.sendMessage(Command.MESSAGE, "Участнику " + nicTo + ": " + message);
    }
}
