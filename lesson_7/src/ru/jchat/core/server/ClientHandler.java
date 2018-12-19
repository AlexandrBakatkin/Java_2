package ru.jchat.core.server;

import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try{
                    while(true){
                        String msg = in.readUTF();
                        if (msg.startsWith("/auth ")){
                            String[] data = msg.split("\\s");
                            String newNick = server.getAuthService().getNickByLoginAndPass(data[1], data[2]);
                            if (newNick != null){
                                if (!server.isNickBusy(newNick)){
                                    nick = newNick;
                                    sendMsg("/authok");
                                    server.subscribe(this);
                                    break;
                                } else {
                                    sendMsg("Учетная запись уже занята");
                                }
                            } else {
                                sendMsg("Неверный логин/пароль");
                            }
                        }
                        if (msg.startsWith("/reg ")){
                            String [] data = msg.split("\\s");
                            RegService regService = new RegService();

                            try {
                                regService.connect();
                            } catch (ClassNotFoundException e) {
                                System.out.println("Не удалось запустить сервис регистрации");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } finally {
                                regService.disconnect();
                            }
                            try {
                                if (regService.registration(data[1], data[2])){
                                    sendMsg("Регистрация прошла успешно, залогиньтесь");
                                } else {
                                    sendMsg("Регистрация не удалась");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    while(true){
                        String msg = in.readUTF();
                        System.out.println(nick + ": " + msg);
                        if (msg.startsWith("/")){
                            if (msg.equals("/end")) break;
                            if (msg.startsWith("/w")){
                                server.privateMsg(msg, nick);
                                server.privateMsgEcho(msg, nick);
                            }
                        } else {
                            server.broadcastMsg(nick + ": " + msg);
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    nick = null;
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
