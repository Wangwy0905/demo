package com.example.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) {

        //创建线程池对象
        ExecutorService  service=Executors.newFixedThreadPool(2);//包含两个线程对象
        //创建Callable对象
        Demo thread=new Demo();

        service.submit(thread);

        service.submit(thread);

        service.submit(thread);

        //关闭线程池
        service.shutdown();

    }
}
