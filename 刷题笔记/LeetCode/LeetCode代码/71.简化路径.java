import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 *
 * https://leetcode-cn.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (37.85%)
 * Likes:    83
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 54.2K
 * Testcase Example:  '"/home/"'
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）
 * 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 /
 * 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 
 * 
 * 示例 2：
 * 
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 
 * 
 * 示例 3：
 * 
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 
 * 
 * 示例 4：
 * 
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 
 * 
 * 示例 5：
 * 
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 
 * 
 * 示例 6：
 * 
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * 
 */
/*
1. 首先按 / 对字符串进行切割
2. 是目录直接进栈，"." 或者 "" 不做任何操作，".." 将前一级目录出栈，如果栈空不做任何操作
3. 遍历栈，拼接答案
*/
// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        //分割
        String[] strings = path.split("/");
        //定义栈
        Stack<String> stack = new Stack<>();

        //遍历
        for(int i = 0; i < strings.length; ++i){
            if(strings[i].equals(".") || strings[i].equals("")){
                continue;
            } else if(strings[i].equals("..")){
                if(stack.isEmpty()){
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(strings[i]);
            }
        }

        //拼接结果
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            String temp = stack.peek();
            stack.pop();

            stringBuilder.insert(0, "/" + temp);
        }

        //栈空，返回 /
        if(stringBuilder.toString().equals("")){
            stringBuilder.append("/");
        }
        
        return stringBuilder.toString();
    }
}
// @lc code=end

