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
public class PressureTest {
    Logger log = LogManager.getLogger(PressureTest.class);
    // 请求总数
    public static int clientTotal = 20;

    // 同时并发执行的线程数
    public static int threadTotal = 4;

    public static int count = 0;

    @Test
    public void main11() throws Exception {
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
                    // 模拟随机执行时长
                    Thread.sleep(new Random().nextInt(55));
                    log.info("2count:{}"+ count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}"+ count);
    }

    private synchronized  void add() {
        log.info("1count:{}"+ count);
        count++;
    }


}
