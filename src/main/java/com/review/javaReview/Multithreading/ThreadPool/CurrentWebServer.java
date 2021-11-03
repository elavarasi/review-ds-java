package com.review.javaReview.Multithreading.ThreadPool;

//import sun.tools.jconsole.Worker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CurrentWebServer {
    private static final int SERVERPORT = 8080;
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(SERVERPORT);
        while(true) {
            final Socket connection = serverSocket.accept();
            Runnable task = () -> {
//                    Worker.handleRequest(connection);
                try {
                    System.out.println(connection.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            new Thread(task).start();
        }
    }
}
