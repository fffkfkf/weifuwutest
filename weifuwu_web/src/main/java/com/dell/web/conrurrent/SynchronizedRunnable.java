package com.dell.web.conrurrent;

/**
 * @author gmq
 * @date 2020/1/26
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class SynchronizedRunnable implements Runnable{
    private int index = 1;
    //readonly shared data.
    private final static int MAX = 500;
    //this
    @Override
    public void run() {
        while (true) {
            if (ticket())
                break;
        }
    }
    private synchronized   boolean ticket() {

            //1. getField
            if (index > MAX)
                return true;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //index++=>index = index+1
            //1. get Field index
            //2. index = index+1
            //3. put field index
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            return false;

    }
}
