package com.shengwm;

import java.util.HashMap;
import java.util.Map;

/**
 * 保持城市天际线
 *
 * @author shengwm
 * @create 2018-05-25 14:21
 **/
public class Leetcode807 {
    public static void main(String[] args) {

        int[][] grid = {{59,88,44},{3,18,38},{21,26,51}};
        int n = maxIncresaseKeepingSkyLine(grid);

        System.out.println(n);
    }

    public static  int maxIncresaseKeepingSkyLine(int[][] grid) {
        int N = grid.length;
        int[] rowmaxes = new int[N];
        int[] colmaxes = new int[N];
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                rowmaxes[r] = Math.max(rowmaxes[r], grid[r][c]);
                colmaxes[c] = Math.max(colmaxes[c], grid[r][c]);
            }
        }

        int ans = 0;
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                ans += Math.min(rowmaxes[r], colmaxes[c]) - grid[r][c];
            }
        }

        return ans;
    }
}
