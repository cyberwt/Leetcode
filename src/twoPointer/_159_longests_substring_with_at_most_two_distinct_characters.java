package twoPointer;

import java.util.HashMap;

/**
 *
 * 本来想直接出掉前面的值，但其实不对，要不断iterate,取排掉 count == 2 的情况
 * while 去排除 count ==2
 * 8/13/20.
 */
public class _159_longests_substring_with_at_most_two_distinct_characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if( s.length() <= 1){
            return s.length();
        }
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int fast = 0,slow =0;
        int count = 0;
        int res = 0;
        //可以考虑，我们还需要别的限制条件么
        //不能直接存 index, 这样break掉了中间的情况 abbaccccc 这样就会直接弄坏，没有学到遍历的思想
        while(fast < len){
            char val = s.charAt(fast);
            map.put(val, map.getOrDefault(val,0)+1);
            if(map.get(val) == 1){
                count++;
                while(count > 2){
                    char pre = s.charAt(slow);
                    map.put(pre, map.get(pre)-1);
                    if(map.get(pre) == 0){
                        count--;
                    }
                    slow++;
                }
            }
            res = Math.max(res, fast- slow+1);
            fast++;
        }
        return res;
    }
}
