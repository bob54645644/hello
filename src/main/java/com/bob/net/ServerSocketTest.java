package com.bob.net;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("服务启动成功！");
            while (true){
                Socket incoming = server.accept();

                Scanner in = new Scanner(incoming.getInputStream(), "UTF-8");
                PrintWriter out = new PrintWriter(incoming.getOutputStream(),true);

                out.println("Hello ! ");
                while (in.hasNextLine()) {
                    out.println("Echo:"+in.nextLine());
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
