package com.review.javaReview.Multithreading.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {

    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        for(;;) {
            Socket sock = serverSocket.accept();
            System.out.println(sock.getInputStream());
            /*processReq(sock);*/
        }
    }

}
