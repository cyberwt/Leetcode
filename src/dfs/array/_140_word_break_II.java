package dfs.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *  Error:
 * > 为什么dfs里只有一层循环了，因为每次下去的时候,s-> newStr, index 自然不是1了
 *
 * > 而且操作的时候，自然而然在退出前 map.add(s, res)
 *
 *
 * hashmap (wordbreak1里的hashset)帮我保存s，如果有了,别进去再查一遍
 * 分情况讨论的特别巧:
 * if(remain.length() == 0){
       res.add(word);
   }else{
       for(String str: dfs(remain, wordDict, map)){
           res.add( word + " " + str);
       }
  }
 * In the case: wordDict = ["a", "aa", "aaa", "aaaa", ... ]; s = "aaaaaaaaa...a".
 * The output list will contain 2^n strings. Since it takes O(n) time to create a new string,
 * does it mean the time complexity of your solution is
 *  T: O(n * 2^n)
 *  S:O(N^2) for each substring in String s
 *
 *
 * 4/6/21.
 */
public class _140_word_break_II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }

    public List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map){
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new LinkedList<String>();
        for(String word: wordDict){
            if(s.startsWith(word)){
                String remain = s.substring(word.length());
                if(remain.length() == 0){
                    res.add(word);
                }else{
                    for(String str: dfs(remain, wordDict, map)){
                        res.add( word + " " + str);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
