package array.slidingWindow;

/**
 *
 *
 * 内层，可以用while 也可以用if, 你看真正打破的是什么规则
 *
 * Error:
 *
 *  1. cnt = s.length  not from cnt = 0;
 *  2. map[pre] -- 之后，判断的是: if( map[pre] >= 0)
 *  但放在map[pre]之后，就是: if( map[pre] >= 0)
 *
 * 3/29/21
 *
 *
 *
 *
 * 往公式里面套
 * while(right++
 *
 *   while(left++
 * > 没理解为什么  if (j-i == s1.length())
 *
 * 其实此时j 已经多了1了
 *
 *
 * 2/8/21.
 */
public class _567_permutation_in_string {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        for (char c: s1.toCharArray()) counts[c-'a']++;
        int i = 0, j = 0;
        while(j < s2.length()) {
            char c = s2.charAt(j++);
            counts[c-'a']--;
            while(counts[c-'a'] < 0) {
                char c2 = s2.charAt(i++);
                counts[c2-'a']++;
            }
            if (j-i == s1.length()) return true;
        }
        return false;
    }
}
