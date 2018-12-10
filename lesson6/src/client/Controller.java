package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Controller {
    private Socket socket;
    private Scanner inputStream;
    private PrintWriter outputStream;

    final String SERVER_IP = "localhost";
    final int SERVER_PORT = 8189;

    public Controller(){
        try{
           socket = new Socket(SERVER_IP, SERVER_PORT);
           inputStream = new Scanner(socket.getInputStream());
           outputStream = new PrintWriter(socket.getOutputStream(), true);
           System.out.println(inputStream.nextLine());
           outputStream.println("Hello");

           Thread thread = new Thread(new Runnable() {
               @Override
               public void run() {

                       try {
                           while (true){

                               if(inputStream.hasNext()){
                                   String s = inputStream.nextLine();
                                   if(s.equals("/end")){
                                       break;
                                   }
                               System.out.println("From server: " + s);

                               }
                           }
                       } finally {
                           try {
                               socket.close();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
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
                       outputStream.println(str);
                   }
               }
           });

           thread.setDaemon(true);
           thread.start();
           threadOut.setDaemon(true);
           threadOut.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}