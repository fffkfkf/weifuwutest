package suanfa.字符流中第一个不重复的字符;

import java.util.*;

/**
 * 剑指offer：50
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * @author gmq
 * @date 2020/6/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2my {

    static char findFirstChar(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (map.containsKey(c)){
                Integer integer = map.get(c);
                map.put(c,integer+1);
            }else {
                map.put(c,0);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c).equals(0)){
                return c;
            }

        }

        return  ' '; //
    }

    public static void main(String[] args) {
        char firstChar = findFirstChar("大ssssss死死死死死死死死v大");
        System.out.println(firstChar);


    }

}
