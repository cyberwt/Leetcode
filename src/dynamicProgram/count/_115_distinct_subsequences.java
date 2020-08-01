package dynamicProgram.count;

/**
 *
 * 基本步骤
 * > 构建状态： 化简成子问题， 最后一步是什么
 * new int[s.length()+1][t.length()+1]; 能不能取到s,t从位置上能包括几个数，一个都取不到，能娶到一个
 * > 初始化 & 边界条件
 * int[i][0]  = 0 我loop 一遍原数组，一个我也不换的计数 是1
 *
 * >转移方程  dp[i][j] means I get my value not  need to change ans,
 *           dp[i][j+1] means I need to delete the value inorder to make them euqals
 * if(s.charAt(i) == t.charAt(j)){
       dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
   }else{
       dp[i+1][j+1] = dp[i][j+1];
   }
 *
 *
 *7/30/20.
 */
public class _115_distinct_subsequences {
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return 0;
        }
        // construct ans
        int[][] dp = new int[s.length()+1][t.length()+1];
        // initial vals
        for(int i=0; i<=s.length(); i++){
            dp[i][0] = 1;
        }

        // get answers
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                }else{
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args){
        _115_distinct_subsequences solution = new _115_distinct_subsequences();

        int test = solution.numDistinct("rabbits","b");
        System.out.println(test);
    }
}
