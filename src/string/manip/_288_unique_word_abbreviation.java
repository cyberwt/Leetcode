package string.manip;

import java.util.HashMap;

/**
 *
 * 建hashmap, 不符合题意的，直接剔出，用"" 表示
 *
 * O(1) is hashmap contains' ideal case, O(N) is the word
 * T:O(N) S:O(N)
 * 10/24/20.
 */
public class _288_unique_word_abbreviation {
    HashMap<String, String> map;
    public _288_unique_word_abbreviation(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String str:dictionary){
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key) && !map.get(key).equals(str))
                map.put(key, "");
            else
                map.put(key, str);
        }
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key)||map.get(key).equals(word);
    }

    private String getKey(String str){
        if(str.length()<=2) return str;
        return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    }
}
