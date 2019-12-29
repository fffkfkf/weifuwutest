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
public class PressureTestunsafe {
    Logger log = LogManager.getLogger(PressureTestunsafe.class);
    // 请求总数
    public static int clientTotal = 900000000;

    public static int count = 0;

    /**
     * 会产生并发问题：count总数:{}1957
     *
     * @throws Exception
     */
    @Test
    public void main11() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    add();
                } catch (Exception e) {
                    log.error("exception", e);
                }

            });
        }
        executorService.shutdown();
        log.info("count总数:{}" + count);
    }

    private void add() {
        count++;
    }


}
