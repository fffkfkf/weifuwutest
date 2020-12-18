package com.dell.web.conrurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author gmq
 * @date 2020/1/26
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class BankVersion3 {

    public static void main(String[] args) throws IOException {
        final SynchronizedRunnable ticketWindow = new SynchronizedRunnable();
        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }





}
