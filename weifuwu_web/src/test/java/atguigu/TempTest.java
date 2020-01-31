package atguigu;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author gmq
 * @date 2019/12/31
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TempTest {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.shutdown();


    }


    @Test
    public void test1() {

    }


}
