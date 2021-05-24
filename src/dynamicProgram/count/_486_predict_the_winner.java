package dynamicProgram.count;

/**
 * 理解
 *

 在记忆化递归的基础上，稍作修改即可。

 比照递归函数的定义，dp[i][j]: 当前玩家在数组[i:j]中先手，所赢过对方的分数。

 比照递归的终止条件，有 base case：当i == j时，dp[i][j] = nums[i]。

 比照递归函数的返回值：max(nums[i] - helper(i+1, j), nums[j] - helper(i, j-1))，有状态转移方程：dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])

 注意，要满足i <= j，所以只用填半张表。

 https://leetcode-cn.com/problems/predict-the-winner/solution/shou-hua-tu-jie-san-chong-xie-fa-di-gui-ji-yi-hua-/
 *
 * 4/25/21.
 *
 * 退出条件:
 * 1/. 无法比较谁胜谁负
 * 2/. 该值已经存在
 *  if(i > j) return 0;
 *
 */
public class _486_predict_the_winner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Integer[][] memo = new Integer[nums.length][nums.length];
        return dfs(nums,0,nums.length-1,memo) >=0;
    }

    public int dfs(int[] nums, int i, int j, Integer[][] memo){
        if(i > j) return 0;
        if(memo[i][j] != null) return memo[i][j];
        memo[i][j] = Math.max(nums[i] - dfs(nums,i+1,j,memo),
                nums[j] - dfs(nums,i,j-1,memo));

        return memo[i][j];
    }
}
