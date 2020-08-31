package bingfa;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * @author gmq
 * @date 2020/8/20
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class OOMTest2 {
    byte[] bb = new byte[1024 * 1024 * 1000]; // 100mb

//会出现oom
    public static void main(String[] args) throws InterruptedException {
        ArrayList<OOMDemo> arrayList = new ArrayList();
        while (true) {
            arrayList.add(new OOMDemo());
            Thread.sleep(500);
        }
    }

    //会出现oom
    @Test
    public void tests() throws InterruptedException, IllegalAccessException, InstantiationException {
        ArrayList<byte[]> arrayList = new ArrayList();

        OOMTest2 oomTest2 = OOMTest2.class.newInstance();
        oomTest2.tests33();
        //Constructor.class.newInstance().

    }

    public void tests33(){
        System.out.println(33);

    }




}
