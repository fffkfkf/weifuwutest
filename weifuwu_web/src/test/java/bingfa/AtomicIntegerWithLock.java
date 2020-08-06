package bingfa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gmq
 * @date 2020/7/11
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */

public class AtomicIntegerWithLock {

    private int value;
//ReentrantLock ???
    private Lock lock = new ReentrantLock();

    public AtomicIntegerWithLock() {
        super();
    }

    public AtomicIntegerWithLock(int value) {
        this.value = value;
    }

    public final int get() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    public final void set(int newValue) {
        lock.lock();
        try {
            value = newValue;
        } finally {
            lock.unlock();
        }

    }

    public final int getAndSet(int newValue) {
        lock.lock();
        try {
            int ret = value;
            value = newValue;
            return ret;
        } finally {
            lock.unlock();
        }
    }

    public final boolean compareAndSet(int expect, int update) {
        lock.lock();
        try {
            if (value == expect) {
                value = update;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndIncrement() {
        lock.lock();
        try {
            return value++;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndDecrement() {
        lock.lock();
        try {
            return value--;
        } finally {
            lock.unlock();
        }
    }

    public final int incrementAndGet() {
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    public final int decrementAndGet() {
        lock.lock();

        try {
            return --value;
        } finally {
            lock.unlock();
        }
    }

    public String toString() {
        return Integer.toString(get());
    }
}
