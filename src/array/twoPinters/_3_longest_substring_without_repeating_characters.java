package array.twoPinters;

import java.util.HashMap;

/**
 * 8/31
 * 1。 重刷，竟然觉得hashmap是错的解
 * 所以不要背题，每道题都以一个标准思路，像第一次爱那样
 * 2。优化，不一定是算法上的改变，code 逻辑本身可以优化么
 *
 *
 *
 * 本来想Set or new char[26] mark index -
 *
 * 其实行的！，
 * 我要的是 HashMap<Character, Integer> -> 来标记 值和index的对应关系
 * 或者我在 int[] 存 index  的位置， 其实也是个 二项map 表达式
 *
 *
 * Error:
 * slow_pointer 只能向前找
 * slow =  Math.max(slow,map.get(s.charAt(i))+1);
 *
 * T:O(N) S:O(N)
 * 6/21/20.
 */
public class _3_longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        // brute force -> T:O(n^2)
        //fast slow pointers-> hashset or new char[26]
        if(s == null || s.length() ==0){
            return 0;
        }

        int slow=0;
        int res=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                slow = Math.max(slow,map.get(s.charAt(i))+1);
            }
            System.out.println(slow + " "+i+ " ");
            res = Math.max(res, i-slow+1);
            map.put(s.charAt(i), i);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i); // * 与map遥相呼应
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;//（下标 + 1） 代表 i 要移动的下个位置
        }
        return ans;
    }

    public static void main(String[] args){
        _3_longest_substring_without_repeating_characters solution = new _3_longest_substring_without_repeating_characters();
        int res = solution.lengthOfLongestSubstring2( "efefregv");
        System.out.println(res);
    }
}
