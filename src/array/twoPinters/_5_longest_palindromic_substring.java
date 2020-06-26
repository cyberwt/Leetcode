package array.twoPinters;

/**
 * Two pointers=> helper(run from middle or from two index)
 *
 * T:O(N) S:O(1)
 * 6/26/20.
 */
public class _5_longest_palindromic_substring {
    public String longestPalindrome(String s) {
        if(s== null ||s.length() == 0){
            return "";
        }
        // return case is only one?
        String res="";
        for(int i=0; i<s.length(); i++){
            String tem = helper(s, i);
            res = tem.length() > res.length() ? tem: res;
        }
        return res;
    }

    public String helper(String s, int index){
        int len = s.length();
        int left = index, right = index;
        while(left >=0 && right< len && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int low = index, high = index+1;
        while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }
        if ((high-low) > (right-left)){
            left = low;
            right = high;
        }
        return s.substring(left+1, right);
    }

    public static void main(String[] args){
        _5_longest_palindromic_substring solution = new _5_longest_palindromic_substring();
        String res = solution.longestPalindrome( "efefregv");
        System.out.println(res);
    }
}
