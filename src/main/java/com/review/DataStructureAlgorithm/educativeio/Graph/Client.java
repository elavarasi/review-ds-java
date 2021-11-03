package com.review.DataStructureAlgorithm.educativeio.Graph;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("localhost", 1234);
        OutputStream output = sock.getOutputStream();
        long t1 = System.currentTimeMillis();
        output.write(new byte[]{(byte) 0xde, (byte) 0xad, (byte) 0xbe, (byte) 0xef});
        byte b4[] = new byte[4];
        new DataInputStream(sock.getInputStream()).readFully(b4);
        long t2 = System.currentTimeMillis();
        System.out.println("t2-t1="+(t2-t1));
    }
}
