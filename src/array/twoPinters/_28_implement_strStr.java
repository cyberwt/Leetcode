package array.twoPinters;

/**
 * Two pointers: 直接两个String 都 loop 一遍
 *
 * CC 处理好
 *
 * T:O(M*N)  S:O(1)
 *
 * 6/7/20.
 */
public class _28_implement_strStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack == null || haystack.length() == 0)
            return -1;

        for (int i = 0; i < haystack.length(); i++) {
            // quick break if length is not enough
            if (i + needle.length() > haystack.length()) break;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        _28_implement_strStr solution = new _28_implement_strStr();

        int res = solution.strStr( "whatabigworld","bigworld");
        System.out.println(res);
    }

}
