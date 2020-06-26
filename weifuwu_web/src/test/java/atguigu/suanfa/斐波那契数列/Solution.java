package atguigu.suanfa.斐波那契数列;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1 .. 可以用公式: 第2项是1 ）。
 * n<=39
 *
 * @author gmq
 * @date 2020/5/2
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        int fibonacci = Fibonacci(45);
        long b = System.currentTimeMillis();
        System.out.println(fibonacci);
        System.out.println((b-a)/1000);
    }
}
