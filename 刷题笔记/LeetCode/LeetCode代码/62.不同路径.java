/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m + 1][n + 1];

        map[0][1] = 1;
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        return map[m][n];
    }
}

