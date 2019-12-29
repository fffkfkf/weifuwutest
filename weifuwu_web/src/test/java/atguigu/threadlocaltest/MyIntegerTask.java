package atguigu.threadlocaltest;

/**
 * @author gmq
 * @date 2019/12/29
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class MyIntegerTask implements Runnable {

    private String name;

    MyIntegerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // ThreadLocal.get方法获取线程变量
            if (null == MyThreadLocal.threadLocal.get()) {
                // ThreadLocal.et方法设置线程变量
                MyThreadLocal.threadLocal.set(0);
                System.out.println("线程" + name + ": 0");
            } else {
                int num = (Integer) MyThreadLocal.threadLocal.get();
                MyThreadLocal.threadLocal.set(num + 1);
                System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
                if (i == 3) {
                    MyThreadLocal.threadLocal.remove();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
