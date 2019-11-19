//package com.example;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class QuartzTest implements Job {
//    private void before(){
//        System.out.println("任务开始执行");
//    }
//
//    @Override
//    public void execute(JobExecutionContext arg0) throws JobExecutionException {
//        before();
//        System.out.println("开始："+System.currentTimeMillis());
//        // TODO 业务
//        System.out.println("结束："+System.currentTimeMillis());
//        after();
//    }
//
//    private void after(){
//        System.out.println("任务开始执行");
//    }
//}
