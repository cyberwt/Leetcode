package iterate_recursioin;

/**
 *
 *
 * 也就是他画的图
 *
 * 存在与：
 *
 * if (sc == pc || pc == '.') {

    } else if (pc == '*') {
        // 0 个match
        if (dp[i][j - 2]) {
        // 一个或多个match
      } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {


    }
 }
 *
 * 3/21/21
 *
 *  去考虑:
 *
 *  -> 跳出条件
 *  -> 构建解决问题的函数 f(n)
 *  -> 降低问题规模，从n到n-1
 *
 *  6/28/20.
 */
public class _10_regular_expression_matching {
    public boolean isMatch(String s, String p) {
        // 出口
        if(p.isEmpty()) return s.isEmpty();
        boolean flag = (!s.isEmpty() && ((s.charAt(0) == p.charAt(0))|| p.charAt(0) == '.'));

        // 切碎问题

        if(p.length() >=2 && p.charAt(1) == '*'){
            // match zero
            // match any preceding
            return ( isMatch(s,p.substring(2))||(flag && isMatch(s.substring(1), p)));
        }else{
            return (flag && isMatch(s.substring(1),p.substring(1)));
        }
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) ||
                            p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
