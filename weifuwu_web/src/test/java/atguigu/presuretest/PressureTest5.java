package atguigu.presuretest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gmq
 * @date 2019/12/29
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class PressureTest5 {


    Logger log = LogManager.getLogger(PressureTest5.class);
    // 请求总数
    public static int clientTotal = 200000;

    public static volatile int count = 0;

    /**
     *不安全的，count总数:{}198997, 为什么???
     *
     * @throws Exception
     */
    @Test
    public void main11() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {

                    synchronized (this){
                        count++;
                    }
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executorService.shutdown();
        log.info("count总数:{}" + count);
    }



}
