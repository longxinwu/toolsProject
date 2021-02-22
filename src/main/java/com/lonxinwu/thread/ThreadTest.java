package com.lonxinwu.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * ThreadPoolExecutor()
 */
public class ThreadTest {
    public static void main(String[] args){
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        // ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();*/
        try{
            int i =1;
            ServerSocket socket = new ServerSocket(8189);
            while(true){
                Socket incoming = socket.accept();
                System.out.println("Socket" + i);
                Runnable r = new ThreadEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
