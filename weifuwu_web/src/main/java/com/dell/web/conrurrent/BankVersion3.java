package com.dell.web.conrurrent;

/**
 * @author gmq
 * @date 2020/1/26
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class BankVersion3 {

    public static void main(String[] args) {
        final SynchronizedRunnable ticketWindow = new SynchronizedRunnable();
        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }





}
