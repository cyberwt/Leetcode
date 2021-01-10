package dfs.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *  Trick：
 *  >每一次都是只有一位的转换
 *
 *  ? 要backtrack,前面的不行，没解啊
 *  > backtrack把不行的拿掉，别再出现，我只求此次唯一解
 *
 *  > dfs(stringbuilder !, int n, int k, int count, set set)
 *
 *  8/26/20.
 */
public class _753_cracking_the_safe {
    public String crackSafe(int n, int k) {
        // Initialize pwd to n repeated 0's as the start node of DFS.
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sbPwd = new StringBuilder(strPwd);

        Set<String> visitedComb = new HashSet<>();
        visitedComb.add(strPwd);

        int targetNumVisited = (int) Math.pow(k, n);

        crackSafeAfter(sbPwd, visitedComb, targetNumVisited, n, k);

        return sbPwd.toString();
    }

    private boolean crackSafeAfter(StringBuilder pwd, Set<String> visitedComb, int targetNumVisited, int n, int k) {
        // Base case: all n-length combinations among digits 0..k-1 are visited.
        if (visitedComb.size() == targetNumVisited) {
            return true;
        }

        String lastDigits = pwd.substring(pwd.length() - n + 1); // Last n-1 digits of pwd.
        for (char ch = '0'; ch < '0' + k; ch++) {
            String newComb = lastDigits + ch;
            if (!visitedComb.contains(newComb))  {
                visitedComb.add(newComb);
                pwd.append(ch);
                if (crackSafeAfter(pwd, visitedComb, targetNumVisited, n, k)) {
                    return true;
                }
                visitedComb.remove(newComb);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }

        return false;
    }
}
