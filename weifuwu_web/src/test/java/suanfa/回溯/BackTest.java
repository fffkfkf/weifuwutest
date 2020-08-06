package suanfa.回溯;

import java.util.Arrays;

/**
 * 使用回溯思想解决八皇后问题
 *
 * @author gmq
 * @date 2020/5/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class BackTest {
    private int[] queen;

    /**
     * 求解八皇后问题
     *
     * @param n
     */
    public void backMethod(int n) {
        queen = new int[n];
        Arrays.fill(queen, -1);
        //从第一个(k)皇后开始
        int k = 0;
        while (true) {
//第k个皇后要移动一个
            queen[k] += 1;
            //判断是否应该回到上一行搜索
            if (queen[k] >= n) {
                //皇后越界,没有位置放皇后

                if (k > 0) {
                    //第k个皇后回到初始状态
                    queen[k] = -1;
                    k--;
                    continue;
                } else {
                    break;
                }
            }

            if (!isMatch(k)) {
                k++;
                if (k >= n) {
                    for (int i = 0; i < n; i++) {
                        System.out.print(queen[i] + " ");
                    }
                    System.out.println();
                    //进入到
                    k--;
                }
            }
        }
    }

    /**
     * 判断第k个皇后是否与之前的皇后冲突
     *
     * @param k
     * @return
     */
    public boolean isMatch(int k) {
        for (int i = k - 1; i > -1; i--) {
            //判断在对角线上: 行列距离相等.
            if (queen[k] == queen[i] || Math.abs(queen[k] - queen[i]) == Math.abs(k - i)) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        BackTest backTest = new BackTest();
        backTest.backMethod(8);
    }


}
