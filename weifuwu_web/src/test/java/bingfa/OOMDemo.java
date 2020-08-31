package bingfa;

import org.junit.Test;

import java.util.ArrayList;

/**
 * java.lang.OutOfMemoryError: Java heap space
 *
 * @author gmq
 * @date 2020/8/20
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class OOMDemo {

    byte[] bb = new byte[1024 * 1024 * 10]; // 100mb

}
