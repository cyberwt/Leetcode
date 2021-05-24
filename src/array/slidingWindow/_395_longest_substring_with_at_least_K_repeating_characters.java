package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**

本来Two pointers, 限制的是一个条件，一个字母的frequency, 多个字母
 而这里是要两个条件，每个字符，都出现k此才合理，那我加一个条件，有[0,26]次，可能会有的条件

 用一个helper函数：
 So to apply two-pointer technique, we need to put some constraint on the sub-string within the window, i.e. the number of unique characters within the window.
 To this end, we can apply two-pointer technique on it but we also need another outer loop to explore every possible cases,
 i.e. the number of unique characters within the window. If we get rid of the outer loop (h = 1 : 26),
 then we have no idea how many unique characters within the window.

 Luckily the maximum number of unique characters is bounded by 26, which means that O(N) time complexity holds. However, due to large constant like I mentioned above, it is slow.

> > 去限制
 用uniqueNum == noLessThanKNum && numTargetDistinct

 3/31/21.
 */
public class _395_longest_substring_with_at_least_K_repeating_characters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        for (int numTargetDistinct = 1; numTargetDistinct <= 26; numTargetDistinct++){
            int len = longestDistinct(s, k, numTargetDistinct);
            max = Math.max(max, len);
        }
        return max;
    }
    private int longestDistinct(String s, int k, int numTargetDistinct){
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int uniqueNum = 0;
        int noLessThanKNum = 0;
        int max = 0;
        while (end < s.length()){
            char cEnd = s.charAt(end);
            map.put(cEnd, map.getOrDefault(cEnd, 0) + 1);
            if (map.get(cEnd) == 1){
                uniqueNum++;
            }
            if (map.get(cEnd) == k){
                noLessThanKNum++;
            }
            end++;
            while (uniqueNum > numTargetDistinct){
                char cStart = s.charAt(start);
                if (map.get(cStart) == k){
                    noLessThanKNum--;
                }
                if (map.get(cStart) == 1){
                    uniqueNum--;
                }
                map.put(cStart, map.get(cStart) - 1);
                start++;
            }
            //
            if (uniqueNum == noLessThanKNum){
                max = Math.max(max, end - start);
            }
        }
        return max;
    }


}
