package com.example.ThreadDemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

//public class Demo {
//    public static void main(String[] test) {
//
//        String args = "1,2,3,4";
//        String[] strs = args.split(",");
//        List<String> list = Arrays.asList(strs);
//        //创建自定义线程对象
//        Thread thread = new Thread();
//
//        thread.start();
//
//        //在主方法中执行for循环
//        for (String s : list){
//            System.out.println("输出：---"+ s);
//        }
//    }

//}

public class Demo implements Callable {

    public Object call() throws Exception {

        System.out.println("我要一个教练:call--");

        Thread.sleep(5000);

        System.out.println("教练来了： " +Thread.currentThread().getName());

        System.out.println("教我游泳,交完后,教练回到了游泳池");

        return null;

    }

}


