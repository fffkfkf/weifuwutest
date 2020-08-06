package suanfa.动态规划;

/**
 * @author gmq
 * @date 2020/5/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class CutRodMy {
    static int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


    private int DownUp(int num,int[] arr){
        for (int i=1;i<num;i++){
            int temp=0;
            for (int j=1;j<=i;j++){
                temp=Math.max(temp,arr[j]+result[i-j]);
            }
            result[i]=temp;
        }
        return result[num];
    }



}
