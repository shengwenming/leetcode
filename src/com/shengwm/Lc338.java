package com.shengwm;

/**
 * 338. Bit位计数
 * @author shengwm
 * @create 2018-05-29 13:29
 **/
public class Lc338 {

    public static  int[] countBits(int num){
        int[] answer = new int[num+1];
        if(num >= 0){
            answer[0] = 0;
        }

        for (int i = 1; i < num; i++) {
            answer[i]=answer[i/2]+i%2;
        }
        return answer;
    }


    public static void main(String[] args){
        int[] ints=countBits(10);
        for (int i = 0; i < ints.length-1; i++) {
            System.out.println(ints[i]);
        }
    }
}
