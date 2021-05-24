package dynamicProgram.count;

/**
 * M2: 递归
 *
 * M1: dp + mem
 *
 * 似懂非懂，为什么方向是向下走的，为什么取的最后的值是 dp[0][s.length()-1]
 *     看图，给的坐标表达方式
 * (i,j-1)  (i,j)
 *         (i+1,j)
 *
 *
 * 4/10/21.
 */
public class _516_longest_palindromic_subsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        return helper(s, 0, n - 1);
    }

    private int helper(String s, int lo, int hi) {
        if (lo > hi) return 0;
        if (lo == hi) return 1;
        int max = 0;

        for (int i = lo; i < hi; i++) {
            for (int j = hi; j >= i; j--) {
                if (j - i + 1 < max) return max;
                if (i == j) {
                    max = Math.max(max, 1);
                    break;
                }

                if (s.charAt(i) == s.charAt(j)) {
                    max = Math.max(max, 2 + helper(s, i + 1, j - 1));
                    break;
                }
            }
        }

        return max;
    }

    public int longestPalindromeSubseq2(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
