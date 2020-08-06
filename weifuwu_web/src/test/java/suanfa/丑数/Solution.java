package suanfa.丑数;

import org.junit.Test;

/**
 * todo??????????不会.
 *
 * @author gmq
 * @date 2020/2/2
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int p2 = 0, p3 = 0, p5 = 0;
        int[] result = new int[index];
        result[0] = 1;
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[p2] * 2,
                    Math.min(result[p3] * 3, result[p5] * 5));
            if (result[i] == result[p2] * 2) {
                p2++;
            }
            if (result[i] == result[p3] * 3) {
                p3++;
            }
            if (result[i] == result[p5] * 5) {
                p5++;
            }
        }
        return result[index -1];
    }

    @Test
    public void test1() {
        int i = GetUglyNumber_Solution(6);
        System.out.println(i);

    }


}
