package suanfa.字符流中第一个不重复的字符;

import java.util.*;

/**剑指offer：50
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * @author gmq
 * @date 2020/6/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2 {

    public char firstUniqChar(String s) {
        // 哈希表存储，<字符，出现次数>
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        //顺序判断，只要找到第一个出现次数为1的就返回
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return s.charAt(i);
        }
        return ' ';// 注意char是单引号.
    }



}
