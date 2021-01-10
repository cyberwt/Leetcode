package array.twoPinters;

import java.util.List;

/**
 * Trick:
 * 1. follow 字典排序
 * if(subStr.length() == res.length() && res.compareTo(subStr)<0) 我直接不比了
 *
 * 2. 双指针
 * 最后比index，就知道比的完不完全
 *
 *  T:O(N) S:O(1)
 * 9/29/20.
 */
public class _524_longest_wordin_dictionary_through_deleting {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        if(s == null || s.length() == 0){
            return res;
        }
        for(String subStr: d){
            if(subStr.length() == res.length() && res.compareTo(subStr)<0){
                continue;
            }
            boolean flag = helper(subStr, s);

            if(flag){
                res = res.length()<=subStr.length() ? subStr: res;
            }
        }
        return res;
    }

    public boolean helper(String subStr, String s){
        int i=0,j=0;
        while(i<subStr.length() && j < s.length()){
            if(subStr.charAt(i) == s.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i==subStr.length();
    }
}
