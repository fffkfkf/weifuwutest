package atguigu.suanfa.第一个只出现一次的字符;

import org.junit.Test;

/**
 * @author gmq
 * @date 2020/2/2
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length() == 0)return -1;
        int[] count = new int[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for(int i=0; i < str.length();i++){
            char c = str.charAt(i);
            count[c]++;


        }

        //其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
        for(int i=0; i < str.length();i++)
            if(count[str.charAt(i)]==1)
                return i;
        return -1;
    }

    @Test
    public void test1() {
        int i = FirstNotRepeatingChar("f2343ydhnd&(%$#Ed%T*ywet");
        System.out.println(i);

    }








}