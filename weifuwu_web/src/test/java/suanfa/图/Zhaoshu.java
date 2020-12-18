package suanfa.图;

import java.util.Scanner;

/**
 * @author gmq
 * @Description 给定整数a1、a2、…an，判断是否可以从中选出若干数，使它们的和恰好为K。 https://blog.csdn.net/NGUP_LEE/article/details/103283076
 * @date 2020/12/15
 */
public class Zhaoshu {

    int n, sum;
    int s = 0, f = 0;
    int[] a = new int[30];
    int[] b = new int[30];

    void dfs(int x) {
        int i, k;
        if (s >= sum)            //还是老样子，函数需要先写结束条件，判断是否结束
        {            //这道题里当s大于条件和时，就没必要再进行递归了，直接进行判断
            if (s == sum)            //当s等于条件和
            {
                if (f == 0)    //f是判断时候有符合条件的输出，当没有符合的时，f始终为0
                    f = 1;
                if (f == 1) {                //符合条件，输出
                    System.out.println("YES");
                    for (i = 0; i < n; i++)        //所有数的下表
                    {
                        if (b[i] == 1)                //利用数组b判断是否需要输出
                        System.out.print(" " + a[i]);
                    }
                    System.out.println();
                }
            }
        }
        for (k = x; k < n; k++) {
            s = s + a[k];        //当前元素，加和s.
            b[k] = 1;            //当前元素的下标，在数组b中标记为1
            dfs(k + 1);        //进入下个dfs
            s = s - a[k];        //回溯，减去加上的元素
            b[k] = 0;            //回溯，把数组b中标记的1返回为0，以便于下次dfs使用
        }
    }

    public static void main(String[] args) {
        Zhaoshu zhaoshu = new Zhaoshu();
        zhaoshu.main2223();
    }

    public void main222() {
        int i, j, k;
       // System.out.println("输入:n,sum");
        Scanner scanner = new Scanner(System.in);
        String ss = null;
        if (scanner.hasNextLine()) {
            ss = scanner.nextLine();
        }
       // System.out.println(ss);
        String[] s = ss.split(" ");
        n = Integer.parseInt(s[0]);
        sum = Integer.parseInt(s[1]);
       // System.out.println("输入数组:");
        Scanner scanner2 = new Scanner(System.in);
        if (scanner2.hasNextLine()) {
            ss = scanner2.nextLine();
        }
        for (i = 0; i < n; i++) {
            String[] s1 = ss.split(" ");
            a[i] = Integer.parseInt(s1[i]);
        }


        dfs(0);                            //从第一个数进入dfs
        if (f == 0)                //此时递归结束，如果f仍为0，则说明没有符合条件的组合
            System.out.println("NO");
    }

    public void main2223() {
        int i, j, k;
        //System.out.println("输入:n,sum");
        String ss = null;
        ss="7 20";
        //System.out.println(ss);
        String[] s = ss.split(" ");
        n = Integer.parseInt(s[0]);
        sum = Integer.parseInt(s[1]);
        //System.out.println("输入数组:");
        ss="2 1 4 5 6 10 16";
        for (i = 0; i < n; i++) {
            String[] s1 = ss.split(" ");
            a[i] = Integer.parseInt(s1[i]);
        }
        dfs(0);                            //从第一个数进入dfs
        if (f == 0)                //此时递归结束，如果f仍为0，则说明没有符合条件的组合
            System.out.println("NO");
    }

}
