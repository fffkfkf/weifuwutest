package bingfa;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author gmq
 * @date 2020/7/5
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class AtomicIntegerFieldUpdaterDemo {
    class DemoData {
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }

    void doit() {
        DemoData data = new DemoData();
        System.out.println("1 ==> " + getUpdater("value1").getAndSet(data, 10));
        System.out.println("3 ==> " + getUpdater("value2").incrementAndGet(data));
        System.out.println("2 ==> " + getUpdater("value3").decrementAndGet(data));
        System.out.println("true ==> " + getUpdater("value4").compareAndSet(data, 4, 5));
    }

    public static void main(String[] args) {
        //字段的描述类型（修饰符public/protected/default/private）是与调用者与操作对象字段的关系一致。
        // 也就是说调用者能够直接操作对象字段，那么就可以反射进行原子操作。但是对于父类的字段，子类是不能直接操作的，尽管子类可以访问父类的字段。
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        demo.doit();
        //在上面的例子中DemoData的字段value3/value4对于AtomicIntegerFieldUpdaterDemo类是不可见的，因此通过反射是不能直接修改其值的。
    }


}
