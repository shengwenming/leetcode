package com.shengwm;

import java.util.HashSet;
import java.util.Set;

/**
 * 771 宝石与石头
 *
 * @author shengwm
 * @create 2018-05-24 14:26
 **/


public class NumJewelsInStones {


    public static int numJewelsInStones(String J, String S) {
        int res = 0;
        char[] chars = J.toCharArray();
        char[] chars1 = S.toCharArray();
        Set set = new HashSet();
        for (char ch : chars) {
            set.add(ch);
        }
        for (char c : chars1) {
            if (set.contains(c)) res++;
        }
        return res;
    }


    public static void main(String[] args) {

        String J = "aA";
        String S = "aAAbbbb";
        int i = numJewelsInStones(J, S);
        System.out.println(i);
    }

}
