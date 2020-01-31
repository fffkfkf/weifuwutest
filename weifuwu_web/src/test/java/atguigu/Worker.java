package atguigu;

/**
 * @author gmq
 * @date 2020/1/26
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Worker implements Runnable {
    private String name;
    public Worker() {
    }

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000*5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
