package com.bob.net;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) {

        try{
            Socket socket = new Socket(InetAddress.getLocalHost(), 8189);
            System.out.println(InetAddress.getLocalHost());

            Scanner in = new Scanner(socket.getInputStream(), "UTF-8");
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            out.println("Hello bob!");

            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
