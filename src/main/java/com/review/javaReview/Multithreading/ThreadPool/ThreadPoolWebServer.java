package com.review.javaReview.Multithreading.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolWebServer {
    private static final int NTHREADS = 100;
    private static final int SERVERPORT = 8080;

    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVERPORT);
        while(true) {
            final Socket connection = serverSocket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
//                    Worker.handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }
}
