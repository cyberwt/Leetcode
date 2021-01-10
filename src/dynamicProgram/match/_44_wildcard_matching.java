package dynamicProgram.match;

/**
 * M1: iterate整个字符串
 *
 * 分情况讨论，slen,plen 怎么走出最优解
 *
 * T:O(N) S:O(1)
 *
 * M2: 动态规划
 * 8/30
 * dp[][]
 * 是怎么走的，走一遍 j ---- 安利往下走
 *
 * 所以 dp[i][j] = dp[i-1][j]||dp[i][j-1]; 完全成立
 *
 * T:O(MN) S:O(MN)
 *
 *
 * 6/29/20.
 */
public class _44_wildcard_matching {
    boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        //遍历整个字符串
        while (s < str.length()){
            // 一对一匹配，两指针同时后移。
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // 碰到 *，假设它匹配空串，并且用 startIdx 记录 * 的位置，记录当前字符串的位置，p 后移
            // !这一步s 没有移动

            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // 当前字符不匹配，并且也没有 *，回退
            // p 回到 * 的下一个位置
            // match 更新到下一个位置
            // s 回到更新后的 match
            // 这步代表用 * 匹配了一个字符

            // ！p的位置在这步就不变了
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //字符不匹配，也没有 *，返回 false
            else return false;
        }
        // ！考虑到匹配的剩余字符串

        //将末尾多余的 * 直接匹配空串 例如 text = ab, pattern = a*******
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    public boolean isMatch2(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        // ?   *
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // inital dp value
        dp[0][0] = true;
        for(int i=1; i<n+1; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    // dp[i][j-1] means  '*' represents empty string
                    // dp[i-1][j] means '*' represents s.charAt(i-1) ??
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
