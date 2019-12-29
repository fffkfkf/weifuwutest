package atguigu.threadlocaltest;

/**
 * @author gmq
 * @date 2019/12/29
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class MyStringTask implements Runnable {

    private String name;

    public MyStringTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (null == MyThreadLocal.threadLocal.get()) {
                MyThreadLocal.threadLocal.set("a");
                System.out.println("线程" + name + ": a");
            } else {
                String str = (String) MyThreadLocal.threadLocal.get();
                MyThreadLocal.threadLocal.set(str + "a");
                System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
            }
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
