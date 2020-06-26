package atguigu.suanfa.动态规划;

import java.util.Arrays;

/**
 * 切钢管问题,普通求解和用备忘录形式的动态规划.
 *
 * @author gmq
 * @date 2020/5/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class CutRod {

    static int Max(int i, int j) {
        return i > j ? i : j;
    }

    /**
     * 自顶向下的递归的方式. 每一次的循环中会有重复计算相同节点的值的情况.
     *
     * @param p
     * @param n
     * @return
     */
    static int cutRod(int p[], int n) {
        if (n == 0) {
            return 0;
        }
        int q = -1;
        for (int i = 1; i <= n; i++) {
//              将n长的钢条，分成i和n-i的两段，i长的那段不切割，而n-i的那段求最大
//             切割收益方式，然后相加；而q值是所有的组合中，最大收益的那个
            q = Max(q, p[i] + cutRod(p, n - i));
        }
        return q;
    }

    static int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /**
     * 带备忘的自顶向下法
     *
     * @param num
     * @param arr
     * @return
     */
    static int UpDown(int num, int[] arr) {
        if (num == 0) return 0;
        if (result[num] != 0) return result[num];

        int temp = 0;
        for (int i = 1; i < num + 1; i++) {

            temp = Math.max(temp, arr[i] + UpDown(num - i, arr));

        }
        result[num] = temp; //将计算的长度为n的钢条切割的长度用数组保存起来
        return temp;
    }

    /**
     * 自底向上法（bottom-up method）
     *
     * @param num
     * @param arr
     * @return
     */
    static int DownUp(int num, int[] arr) {
        for (int i = 1; i < num + 1; i++) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                int temp1 = temp;
                int re = arr[j] + result[i - j];
                temp = Math.max(temp1, re);
            }
            result[i] = temp;
        }
        System.out.println(Arrays.toString(result));
        return result[num];
    }


    public static void main(String[] args) {
        int[] priceShuZu = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

       /* int f = cutRod(priceShuZu, 10);
        System.out.println(f);
        int f2 = UpDown(10, priceShuZu);
        System.out.println(f2);*/
        int i = DownUp(10, priceShuZu);
        System.out.println(i);

    }

}
