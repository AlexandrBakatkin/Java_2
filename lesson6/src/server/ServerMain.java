package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Server started... Waiting client");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            Scanner inputStr = new Scanner(socket.getInputStream());
            PrintWriter outputStr = new PrintWriter(socket.getOutputStream(), true);
            outputStr.println("Hello");

            Thread threadIn = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        {
                        String msg = inputStr.nextLine();
                        System.out.println("From client: " + msg);
                        outputStr.println("echo: " + msg);
                        if (msg.equals("/end")) break;}
                    }
                }
            });

            Thread threadOut = new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String str = new String();
                    while (true){

                        try {
                            str = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        outputStr.println(str);
                    }
                }
            });

            threadIn.setDaemon(true);
            threadIn.start();
            threadOut.setDaemon(true);
            threadOut.start();
            try {
                threadIn.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
