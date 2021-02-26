package twoPointer;

/**
 * 如何
 *
 * 2/21/21
 *
 * 怎么写很优雅，放到下面重新判断，直接用新坐标就可以了, 比s.charAt(i), s.charAt(j) ,不用重启i,j,
 *
 * 1/27/21.
 */
public class _680_valid_palindrome_II {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
