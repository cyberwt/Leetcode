package Hash.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Two hashmap
 *
 * One act as template, another used it to compare
 *
 * 每次是取i开始的， words 为变量的改变
 *
 */
public class _30_substring_with_concatenation_of_all_words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        if(s==null || s.length() == 0 || words == null || words.length == 0){
            return res;
        }

        //Two hashMap, compare and get desired value as expected
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(String str: words){
            map.put(str, map.getOrDefault(str,0) +1);
        }

        int wordLen = words[0].length();
        int len = words.length;
        for(int i=0; i<s.length()-wordLen*len+1; i++){
            HashMap<String, Integer> temMap = new HashMap<String, Integer>();
            int num =0;
            while(num < len){
                String word = s.substring(i+num*wordLen, i + (num + 1) * wordLen);
                if(map.containsKey(word)){
                    temMap.put(word,temMap.getOrDefault(word,0)+1);

                    if(temMap.get(word) > map.get(word)){
                        break;
                    }
                }else{
                    break;
                }
                num++;
            }
            if(num == len){
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        _30_substring_with_concatenation_of_all_words solution = new _30_substring_with_concatenation_of_all_words();
        String[] words = {"foo","bar"};
        List<Integer> res = solution.findSubstring("barfoothefoobarman",words);
        System.out.println(res);
    }

}
