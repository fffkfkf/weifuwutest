package suanfa.斐波那契数列;

/**
 * 这个真的好快呀!!!!!!!!!!!!!!!!!!!!
 * @author gmq
 * @date 2020/5/2
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2 {

    public static int Fibonacci(int n) {
        int[] a = {0, 1};
        if (n < 2) {
            return a[n];
        }
        int fib = 0;
        int fib0 = 0;
        int fib1 = 1;
        for (int i = 2; i <= n; i++) {
            fib = fib0 + fib1;
            fib0=fib1;
            fib1=fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        double a = System.currentTimeMillis();
        int fibonacci = Fibonacci(45);
        double b = System.currentTimeMillis();
        System.out.println(fibonacci);
        System.out.println(b-a);

    }

}
