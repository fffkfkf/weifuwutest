package suanfa.左旋转字符串;

/**
 * @author gmq
 * @date 2020/4/12
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public static void main(String[] args) {
        String ss="abcXYZdef";
        String s = LeftRotateString(ss, 3);
        System.out.println(s);
    }


    public static String LeftRotateString(String str, int n) {
        if (str==null || "".equals(str)){
            return str;
        }
        String preSubstring = str.substring(0, n);
        String afterSubstring = str.substring(n, str.length());

        return afterSubstring+preSubstring;
    }


}
