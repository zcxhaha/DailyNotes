/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (58.34%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    92.3K
 * Total Submissions: 158.2K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */
/**
 * 双指针解法
 * 无论是否是 0，快指针均向后移动，非 0 慢指针向后移动
 */
// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int last = 0;
        for(int fast = 0; fast < nums.length; ++fast){
            if(nums[fast] != 0){
                int tmp = nums[last];
                nums[last] = nums[fast];
                nums[fast] = tmp;
                last++;
            }
        }
    }
}
// @lc code=end

