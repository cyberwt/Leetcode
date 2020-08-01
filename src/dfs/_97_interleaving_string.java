package dfs;

/**
 * M1: keep backtracking
 *
 * M2: DP for two dimension
 * 巧妙的 [0,i)  dp[i][j] =
 *
 * 四种情况：
 * if (i == 0 && j == 0) {
       dp[j] = true;
   } else if (i == 0) {
       dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
   } else if (j == 0) {
       dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
 } else {
 *
 * M3: DP for 1 dimension
 *
 * 7/15/20.
 */
public class _97_interleaving_string {
    public boolean isInterleave1(String s1, String s2, String s3) {
        return getAns(s1, 0, s2, 0, s3, 0);
    }

    private boolean getAns(String s1, int i, String s2, int j, String s3, int k) {
        //长度不匹配直接返回 false
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // i、j、k 全部达到了末尾就返回 true
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        // i 到达了末尾，直接移动 j 和 k 不停比较
        if (i == s1.length()) {
            while (j < s2.length()) {
                if (s2.charAt(j) != s3.charAt(k)) {
                    return false;
                }
                j++;
                k++;
            }
            return true;
        }
        // j 到达了末尾，直接移动 i 和 k 不停比较
        if (j == s2.length()) {
            while (i < s1.length()) {
                if (s1.charAt(i) != s3.charAt(k)) {
                    return false;
                }
                i++;
                k++;
            }
            return true;
        }
        //判断 i 和 k 指向的字符是否相等
        if (s1.charAt(i) == s3.charAt(k)) {
            //后移 i 和 k 继续判断，如果成功了直接返回 true
            if (getAns(s1, i + 1, s2, j, s3, k + 1)) {
                return true;
            }
        }
        //移动 i 和 k 失败，尝试移动 j 和 k
        if (s2.charAt(j) == s3.charAt(k)) {
            if (getAns(s1, i, s2, j + 1, s3, k + 1)) {
                return true;
            }
        }
        //移动 i 和 j 都失败，返回 false
        return false;
    }


    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleave3(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s2.length()];
    }
}
