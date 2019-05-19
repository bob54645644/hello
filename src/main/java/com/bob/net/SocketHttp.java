package com.bob.net;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketHttp {
    public static void main(String[] args) {
        try {


            Socket socket = new Socket("www.baidu.com", 80);

            Scanner in = new Scanner(socket.getInputStream(), "UTF-8");
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            out.println("GET / HTTP/1.1");
            out.println("Host: www.baidu.com:80");
            out.println("\r\n");
            out.flush();

            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
