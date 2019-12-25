/*
 * @lc app=leetcode.cn id=807 lang=java
 *
 * [807] 保持城市天际线
 *
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/description/
 *
 * algorithms
 * Medium (79.35%)
 * Likes:    60
 * Dislikes: 0
 * Total Accepted:    7K
 * Total Submissions: 8.8K
 * Testcase Example:  '[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]'
 *
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0
 * 也被认为是建筑物。
 * 
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。
 * 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 * 
 * 建筑物高度可以增加的最大总和是多少？
 * 
 * 
 * 例子：
 * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * 输出： 35
 * 解释： 
 * The grid is:
 * [ [3, 0, 8, 4], 
 * ⁠ [2, 4, 5, 7],
 * ⁠ [9, 2, 6, 3],
 * ⁠ [0, 3, 1, 0] ]
 * 
 * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
 * 
 * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
 * 
 * gridNew = [ [8, 4, 8, 7],
 * ⁠           [7, 4, 7, 7],
 * ⁠           [9, 4, 8, 7],
 * ⁠           [3, 3, 3, 3] ]
 * 
 * 
 * 说明: 
 * 
 * 
 * 1 < grid.length = grid[0].length <= 50。
 * grid[i][j] 的高度范围是： [0, 100]。
 * 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。
 * 
 * 
 */
/**
 * 分别计算行、列的限制，然后直接计算每一个方格可以添加的高度
 */
// @lc code=start
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] row = new int[len];
        int[] col = new int[len];
        int res = 0;

        //同时计算所有行列的最大值
        for(int i = 0; i < len; ++i){
            int tag = -1;
            int fag = -1;
            for(int j = 0; j < len; ++j){
                if(grid[i][j] > tag){
                    tag = grid[i][j];
                }
                if(fag < grid[j][i]){
                    fag = grid[j][i];
                }
            }
            row[i] = tag;
            col[i] = fag;
        }
        // //计算所有列的最大值
        // for(int i = 0; i < len; ++i){
        //     int tag = -1;
        //     for(int j = 0; j < len; ++j){
        //         if(grid[j][i] > tag){
        //             tag = grid[j][i];
        //         }
        //     }
        //     col[i] = tag;
        // }

        //计算每一个格可以添加的数量
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res += (Math.min(row[i], col[j]) - grid[i][j]);
            }
        }

        return res;
    }
}
// @lc code=end

