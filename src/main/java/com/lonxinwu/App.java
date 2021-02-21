package com.lonxinwu;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        /*long amt = 500l;
        long discount = (long) (amt *0.1);
        double dou = amt * 0.1;
        double num = amt-dou;
        System.out.println( String.valueOf(discount/100)+"----"+String.valueOf(dou/100)+"----"+(amt-dou)/100);*/
        //String url = "12343543qr";
        //System.out.println(url.contains("QR"));

        //网络编程学习
        /*try {
            if (args.length > 0) {
                String host = args[0];
                InetAddress[] addresses = InetAddress.getAllByName(host);
                for (InetAddress address : addresses) {
                    System.out.println("address:" + address);
                }
            } else {
                InetAddress localAddress = InetAddress.getLocalHost();
                System.out.println("localAddress:" + localAddress);
            }
        } catch (Exception e) {
            System.out.println(e);
        }*/
        try {
            ServerSocket s = new ServerSocket(8189);
            try(Socket incoming = s.accept()){
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try(Scanner in = new Scanner(inStream)){
                    PrintWriter out = new PrintWriter(outStream, true );
                    out.println("hello! Enter BYE to exit.");
                    boolean done = false;
                    while(!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE")){
                            done = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
}
