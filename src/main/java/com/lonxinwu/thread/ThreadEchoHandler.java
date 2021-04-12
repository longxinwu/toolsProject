package com.lonxinwu.thread;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadEchoHandler implements Runnable{
    private Socket incoming;
    public ThreadEchoHandler(Socket i){
        incoming = i;
    }
    @Override
    public void run(){
        try{
            try{
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true);
                out.println("Hello! Enter BYE to Exit");
                boolean done = false;
                while(!done && in.hasNextLine()){
                    String line = in.nextLine();
                    out.println("Echo: " + line);
                    if(line.trim().equals("BYE")){
                        done = true;
                    }
                }
            }finally {
                incoming.close();
            }
        }catch (Exception e){
            System.out.println("error" + e);
        }
    }
}
