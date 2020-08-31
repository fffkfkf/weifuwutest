package bingfa;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author gmq
 * @date 2020/8/7
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class worker1 extends Thread {
    Logger log = LogManager.getLogger(worker1.class);

    @Override
    public void run() {
        Thread.currentThread().setName("worker1--");
        log.info("worker1111");



    }
}
