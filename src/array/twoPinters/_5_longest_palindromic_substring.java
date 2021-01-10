package array.twoPinters;

/**
 * 10.4
 * 二刷，不会了？
 *
 *  M1: 全局变量
 *  . 每一个char 在string里都扫一遍，用全局变量start, len
 *  . find要find 两种情况 find(s,i,i)   find(s,i,i+1)
 *
 * M1: dp
 * 1/ 理解 Iteration
 * 走的是矩阵的斜向下位置，使j一直大于i
 *  (j-i<3 || dp[i+1][j-1]); 很聪明的避开了越界的情况
 *
 * 2/ dp的变化方式 i-j<3
 *
 * It is just exclude the condition dp[i + 1][j - 1] when i and j are within 2 index distance. In short,
   if i == j, dp[i][j] = s.charAt(i) == s.charAt(j)
   i + 1 == j, dp[i][j] = s.charAt(i) == s.charAt(j)
    i + 2 ==j , dp[i][j] = s.charAt(i) == s.charAt(j) and since the middle one doesn't matter.
   Only when i + 3 == j, dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
 *
 *
 *
 *
 * Two pointers=> helper(run from middle or from two index)
 *
 * T:O(N) S:O(1)
 * 6/26/20.
 *
 *
 *
 *
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

    int index =0, len =0;
    public String longestPalindrome3(String s) {
        if(s == null || s.length() == 0){
            return  "";
        }
        if(s.length() ==1) return s;
        for(int i=1; i<s.length(); i++){
            find(s,i,i);
            find(s,i-1,i);
        }
        return s.substring(index,index+len);
    }

    public void find(String s, int start, int end){
        int left = start;
        while(start>= 0 && end < s.length()){
            if(s.charAt(start) == s.charAt(end)){
                if(len <= (end-start+1)){
                    index = start;
                    len = end-start+1;
                }
                start--;
                end++;
            }else{
                return;
            }
        }
        return;
    }


    public String longestPalindrome2(String s) {
        // 输入的三种情况
        //怎么把局域扩大
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";

        //一定是这个顺序么
        //在j大于i时
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                if(dp[i][j] && (j-i+1) >= res.length()){
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        _5_longest_palindromic_substring solution = new _5_longest_palindromic_substring();
        String res = solution.longestPalindrome( "efefregv");
        System.out.println(res);
        String aa = "";
        System.out.println(aa.length());
    }
}
