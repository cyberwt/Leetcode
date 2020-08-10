package dynamicProgram.count;

/**
 * 是dp的变形
 *
 * dp[j][i] 是否 从 i 到j 是回文
 *
 * 是，且 j!=0 那我就可以更新
 *  dp[j][i] = true;
    min = j==0?0:Math.min(min,cut[j-1]+1);
 *
 *
 * T:O(N^2) S:O(N^2/2)
 * 8/2/20.
 */
public class _132_palindrome_partitioning_II {
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int[] cut = new int[len];

        for(int i=0; i<len; i++){
            int min=i;
            for(int j=0; j<=i; j++){
                if((s.charAt(i) == s.charAt(j)) && ( j+1>=i-1 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    min = j==0?0:Math.min(min,cut[j-1]+1);
                }
            }
            cut[i] = min;
        }
        return cut[len-1];
    }

}
