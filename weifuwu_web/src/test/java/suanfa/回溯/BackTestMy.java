package suanfa.回溯;


import java.util.Arrays;

/**
 * @author gmq
 * @date 2020/5/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class BackTestMy {
    private int[] queen;

    public void backMethod(int n) {
        queen = new int[n];
        Arrays.fill(queen, -1);
        int k = 0;
        while (true) {
            //第k个皇后要移动一个
            queen[k] += 1;
            //判断是否应该回到上一行搜索
            if (queen[k] >= n) {
//皇后越界,没有位置放皇后
                if (k > 0) {
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

                    k--;
                }


            }


        }
        //从第一个(k)皇后开始

//第k个皇后要移动一个
        //判断是否应该回到上一行搜索
        //皇后越界,没有位置放皇后
        //第k个皇后回到初始状态


    }

    public boolean isMatch(int k) {
        for (int i = k - 1; i > -1; i--) {
            if (queen[k] == queen[i] || Math.abs(queen[k] - queen[i]) == Math.abs(k - i)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        BackTestMy backTest = new BackTestMy();
        backTest.backMethod(8);
    }

}
