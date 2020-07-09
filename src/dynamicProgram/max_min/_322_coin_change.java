package dynamicProgram.max_min;

/**
 *
 * 确定状态 什么解法 开数组 M+1 !!
 * 子问题 f(n) = min (f(n), f(n-coin[j])+1)
 * 初始条件 & 边界条件 dp[i] = Integer.MAX_VALUE
 * 计算顺序:
 * if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE  )
 *
 *
 *
 * T:O(M*N), S:O(N)
 *
 * 7/4/20.
 */
public class _322_coin_change {

    public int coinChange(int[] coins, int amount) {
        if(coins == null ||coins.length==0){
            return -1;
        }

        int[] dp = new int[amount+1];
        dp[0]=0;

        for(int i=1; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length; j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE  ){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }

    public static void main(String[] args){
        _322_coin_change solution = new _322_coin_change();
        int[] num1 = {1,2,3};
        int test = solution.coinChange(num1,6);
        System.out.println(test);
    }
}
