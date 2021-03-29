package array.slidingWindow;

import java.util.LinkedList;
import java.util.List;

/**
 * 还是有点特殊，你不需要，while 去处理left
 *
 * if(right -left == p.length()) => 继续去推进len的关系
 *
 * 3/28/21.
 */
public class _438_find_all_anagrams_in_a_string {
    public List<Integer> findAnagrams(String s, String p) {
        // sliding window
        // map to record original array
        // left keeps moving when there is, otehr wise, right keeps close the loop
        List<Integer> res = new LinkedList<Integer>();
        if(s == null || p == null || s.length() < p.length()){
            return res;
        }
        // input validation
        int[] map = new int[256];
        for(char c: p.toCharArray()){
            map[c]++;
        }
        int left=0, right=0;
        int cnt = p.length();
        while(right < s.length()){
            if(map[s.charAt(right)] >0){
                cnt--;
            }
            map[s.charAt(right)]--;
            right++;
            if(cnt == 0){
                res.add(left);
            }
            // E1: right此时已经多了1个1， 不用再加1了
            if(right-left == p.length()){
                map[s.charAt(left)]++;
                if(map[s.charAt(left)] > 0){
                    cnt++;
                }
                left++;
            }
        }
        return res;
    }
}
