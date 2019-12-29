package atguigu.presuretest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author gmq
 * @date 2019/12/29
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class pressuretest6safe {

    /*
    请求总数:2000
        并发数：1 ，时间         11673  11750
        并发数：2  ， 时间         5896   5848
     */

    Logger log = LogManager.getLogger(pressuretest6safe.class);

    // 请求总数
    public static int clientTotal = 90000;

    // 同时并发执行的线程数
    public static int threadTotal = 2;

    public static int count = 0;

    @Test
    public void main22() throws Exception {
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //Semaphore 是 synchronized 的加强版，作用是控制线程的并发数量.只允许threadTotal个线程同时访问.
        final Semaphore semaphore = new Semaphore(threadTotal);
        //countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    //log.info("2count:{}" + count);
                    semaphore.release();
                } catch (Exception e) {
                    //log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}" + count);
        long end = System.currentTimeMillis();
        long time= end-begin;
        log.info("time:{}" + time);
    }

    private synchronized static void add() {

        count++;
    }
}
