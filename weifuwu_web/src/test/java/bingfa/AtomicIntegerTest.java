package bingfa;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 *
 * @author gmq
 * @date 2020/7/5
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class AtomicIntegerTest {

    @Test
    public void testAll() throws InterruptedException{
        final AtomicInteger value = new AtomicInteger(10);
        assertFalse(value.compareAndSet(1, 2));
        assertEquals(value.get(), 10);
        assertTrue(value.compareAndSet(10, 3));
        assertEquals(value.get(), 3);
        value.set(0);
        //
        assertEquals(value.incrementAndGet(), 1);
        assertEquals(value.getAndAdd(2),1);
        assertEquals(value.getAndSet(5),3);
        assertEquals(value.get(),5);
        //
        final int threadSize = 10;
        Thread[] ts = new Thread[threadSize];

        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                public void run() {
                    value.incrementAndGet();
                }
            };
        }
        //
        for(Thread t:ts) {
            t.start();
        }
        for(Thread t:ts) {
            t.join();
        }
        //
        assertEquals(value.get(), 5+threadSize);
    }

}
