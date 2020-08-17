package bingfa;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * @author gmq
 * @date 2020/8/7
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Worker2 implements Runnable {
    Logger log = LogManager.getLogger(CreatThread1.class);

    @Override
    public void run() {
        //Thread.currentThread().setName("Worker2线程");
        log.info("Worker2线程");
        //int a=1/0;

    }




}
