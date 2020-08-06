package bingfa;

/**
 * @author gmq
 * @date 2020/7/11
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Binffaceshi {

    //在这个例子中每次启动10个线程，每个线程计算100000次自增操作，重复测试10次，下面是某此测试的结果：
    static int staticValue = 0;

    public static void main(String[] args) throws Exception{
        final int max = 10;
        final int loopCount = 100000;
        long costTime = 0;
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();
            final AtomicIntegerWithLock value1 = new AtomicIntegerWithLock(0);
            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            value1.incrementAndGet();
                        }
                    }
                };
            }
                for(Thread t:ts) {
                    t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        System.out.println("cost1: " + (costTime));
        //
        System.out.println();
        costTime = 0;
        //
        final Object lock = new Object();
        for (int m = 0; m < max; m++) {
            staticValue=0;
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            synchronized(lock) {
                                ++staticValue;
                            }
                        }
                    }
                };
            }
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        //
        System.out.println("cost2: " + (costTime));
    }





}
