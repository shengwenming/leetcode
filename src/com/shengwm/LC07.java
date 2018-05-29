package com.shengwm;


/**
 * 7. 反转整数
 * Created by Shengwm on 2018/5/29.
 */
public class LC07 {
    public static  int reverse(int x) {
        long ret = 0;


        if (x == 0) return 0;
        while (x != 0){
            ret=ret*10+x%10;
            x /=10;
        }

        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE){
            return 0;
        }
        return (int) ret;
    }

    public static void main(String[] args){
        int n = reverse(-312);
        System.out.print(n);
    }
}
