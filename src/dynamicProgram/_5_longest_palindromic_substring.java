package dynamicProgram;

/**
 *
 * M1: loop the string in 2 for
 *
 * M2: dp to check if it exists => 不难想的 // bottom up, 从后向前
 * https://leetcode.com/problems/longest-palindromic-substring/discuss/151144/Bottom-up-DP-Logical-Thinking
 * 4/12/21.
 */
public class _5_longest_palindromic_substring {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public String longestPalindrome2(String s) {
        // Corner cases.
        if (s.length() <= 1) return s;

        int len = s.length(), longestPalindromeStart = 0, longestPalindromeLength = 1;
        // state[i][j] true if s[i, j] is palindrome.
        boolean[][] state = new boolean[len][len];

        // Base cases.
        for (int i = 0; i < len; i++) {
            state[i][i] = true; // dist = 0.
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int dist = 1; dist < len - i; dist++) {
                int j = dist + i;
                state[i][j] = (dist == 1) ? s.charAt(i) == s.charAt(j) : (s.charAt(i) == s.charAt(j)) && state[i + 1][j - 1];
                if (state[i][j] && j - i + 1 > longestPalindromeLength) {
                    longestPalindromeLength = j - i + 1;
                    longestPalindromeStart = i;
                }
            }
        }

        return s.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength);
    }
}
