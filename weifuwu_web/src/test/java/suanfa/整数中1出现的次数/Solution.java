package suanfa.整数中1出现的次数;

import org.junit.Test;

/**求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * @author gmq
 * @date 2020/1/27
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {

        int count = 0;
        while (n > 0) {
            String s = String.valueOf(n);
            char c = s.charAt('1');
            char[] chars = s.toCharArray();
            n--;
            for (char a : chars) {
                if (a == '1') {
                    count++;
                }
            }
        }
        return count;
    }



    @Test
    public void test1() {
        NumberOf1Between1AndN_Solution(13);

    }




}
