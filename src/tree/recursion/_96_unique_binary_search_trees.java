package tree.recursion;

/**
 *
 * 仔细想要理解的：动规
 *
 * dp[len] += dp[left] * dp[right];
 *
 * 7/16/20.
 */
public class _96_unique_binary_search_trees {
    public int numTrees(int n) {
        if(n == 0){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int len=1; len<=n; len++){
            for(int root =1; root<=len; root++){
                int left = root-1;
                int right = len-root;
                dp[len] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
