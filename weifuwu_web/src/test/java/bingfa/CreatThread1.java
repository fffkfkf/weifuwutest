package bingfa;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author gmq
 * @date 2020/8/7
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class CreatThread1 {
    Logger log = LogManager.getLogger(CreatThread1.class);


    /**
     * 继承thread, 开启线程的写法
     */
    @Test
   public  void sss() {
     Thread t= new Thread(()-> System.out.println("33333"));
       System.out.println("主线程开始");
       t.start();
       try {
           t.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("主线程结束");
   }


    /**
     * 继承thread, 开启线程的写法
     */
    @Test
    public  void sss332() {
        Thread thread = new Thread(new worker1());
        thread.start();
        String name = Thread.currentThread().getName();
        log.info(name);

    }

    /**
     * 实现runnable接口
     */
    @Test
    public  void ssswRunnable() {
        Worker2 worker2 = new Worker2();
        Thread sdk = new Thread(worker2, "sdk");
        sdk.start();
        log.info(Thread.currentThread().getName());
    }

    /**
     * 创建线程池
     */
    @Test
    public  void ssswThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int a=0;a<100;a++){
/*
 Future<?> submit = executorService.submit(new Worker2());
            try {
                Object o = submit.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/
            executorService.execute(new Worker2());
        }
        log.info(Thread.currentThread().getName());
    }

    /**
     * 创建线程池
     */
    @Test
    public  void ssswCallable() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Worker3 worker3 = new Worker3();
        for (int a=0;a<5;a++){
            // submit 有三个重载的方法.
            Future<String> future = executorService.submit(worker3);
            System.out.println("future"+future.get());
        }
        executorService.shutdown();
    }

}
