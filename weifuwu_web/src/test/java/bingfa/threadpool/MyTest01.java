package bingfa.threadpool;

/**
 * 内置的线程池的简单使用. 要记住如何使用.
 * @author gmq
 * @date 2020/6/14
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
    练习Executors获取ExecutorService,然后调用方法,提交任务;
 */
public class MyTest01 {
    public static void main(String[] args) {
        test1();
       // test2();
    }

    //练习newCachedThreadPool方法
    private static void test1() {
        //1:使用工厂类获取线程池对象
        ExecutorService es = Executors.newCachedThreadPool();
        //2:提交任务;
        for (int i = 1; i <= 10; i++) {
            es.submit(new MyRunnable(i));
        }
    }

    private static void test2() {
        //1:使用工厂类获取线程池对象
        ExecutorService es = Executors.newCachedThreadPool(new ThreadFactory() {
            int n = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "自定义的线程名称" + n++);
            }
        });
        //2:提交任务;
        for (int i = 1; i <= 10; i++) {
            es.submit(new MyRunnable(i));
            // submit 和execute差不多.
            //es.execute(new MyRunnable(i+100));
        }
    }
}

/*
    任务类,包含一个任务编号,在任务中,打印出是哪一个线程正在执行任务
 */
class MyRunnable implements Runnable {
    private int id;

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        //获取线程的名称,打印一句话
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行了任务..." + id);
    }
}

