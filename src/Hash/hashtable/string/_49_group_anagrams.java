package Hash.hashtable.string;

import java.util.*;

/**
 *
 * Trick:
 * 怎样找到 key-> 对应想要的 ArrayList
 *
 * M1:
 *
 * String -> to char array -> sort char array  S:O(N) -worst  T:O(Nlong)
 *
 * M2:
 *
 * loop to construct a  new char[26]   S:O(N) T:O(n)
 *
 * Point
 *
 * 1: return new ArrayList<>(map.values())
 *
 * 2. map.put not map.add()
 *
 * 3. new ArrayList needs new ArrayList<>()    <>号！
 *
 *
 *
 * 6/14/20.
 */
public class _49_group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // How hashmap get the string and make sure it
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] val = str.toCharArray();
            Arrays.sort(val);
            String keyValue = String.valueOf(val);
            // linkedlist 用初始化么

            if(!map.containsKey(keyValue)) map.put(keyValue, new ArrayList<>());
            map.get(keyValue).add(str);
        }

        return new ArrayList<>(map.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        // How hashmap get the string and make sure it
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] ca = new char[26];
            for (char c : str.toCharArray()) ca[c - 'a']++;
            String keyValue = String.valueOf(ca);
            if(!map.containsKey(keyValue)) map.put(keyValue, new ArrayList<>());
            map.get(keyValue).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
