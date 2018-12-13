package ru.jchat.core.server;

import com.sun.jdi.CharType;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public Server(){
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            clients = new Vector<>();
            authService = new AuthService();
            authService.connect();
            System.out.println("Server started... Waiting clients");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected " + socket.getInetAddress() + " " + socket.getPort() + " " + socket.getLocalPort());
                new ClientHandler(this, socket);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Не удалось запустить сервис авторизации");
        } finally {
            authService.disconnect();
        }
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public boolean isNickBusy(String nick){
        for (ClientHandler o: clients){
            if (o.getNick().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public void broadcastMsg(String msg){
        for (ClientHandler o: clients){
            o.sendMsg(msg);
        }
    }

    public void privateMsg(String msg, String nick) {
        for (ClientHandler o: clients) {
            if(o.getNick().equals(getNick(msg))){
                o.sendMsg("Private message from " + nick + ": " + msg);
            }
        }
    }

    public String getNick(String msg){
        StringBuffer str = new StringBuffer();
        for (int i = 3; i < msg.length(); i++) {
            if (msg.charAt(i) != ' ') {
                str.append(msg.charAt(i));
            } else break;
        }

        return str.toString();
    }

    public void privateMsgEcho(String msg, String nick) {
        for (ClientHandler o: clients) {
            if (o.getNick().equals(nick)){
                o.sendMsg(nick + ": " + "Private message to " + getNick(msg) + ": " + msg);
            }
        }
    }
}
