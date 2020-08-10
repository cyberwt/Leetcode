package dfs;

import java.util.HashSet;
import java.util.List;

/**
 *  M1: dfs +mem
 *
 *  > 想要纯dfs来做，但是会out of memory
 *
 *  用index 帮助记录 loop 到哪里，HashSet recorder 写出，记录不符合题意的index
 *
 *  M2: dp
 *  dp[0,i] means valid index 0 until i makes sense
 *
 *  M2: 是反向构造
 *  跟随dp的含义重新理解
 *
 *
 *  8/4/20.
 */
public class _139_word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s== null || s.length() == 0){
            return true;
        }
        HashSet<String> set = new HashSet<String>();

        for(String str: wordDict){
            set.add(str);
        }
        HashSet<Integer> recorder = new HashSet<Integer>();
        return dfs(s,set, 0,recorder);
    }

    public boolean dfs(String s, HashSet<String> set, int index, HashSet<Integer> recorder){
        if(index == s.length()){
            return true;
        }

        // 需要这里 多加到底部
        for(int i=index+1; i<=s.length(); i++){
            if(recorder.contains(i)) continue;
            if(set.contains(s.substring(index,i))){
                if(dfs(s,set,i,recorder)){
                    return true;
                }
                recorder.add(i);
            }
        }
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if(s== null || s.length() == 0){
            return true;
        }
        HashSet<String> set = new HashSet<String>();

        for(String str: wordDict){
            set.add(str);
        }

        int len = s.length();

        boolean[] dp = new boolean[len];

        //dp[i] means whether dp[0, .. i] can be formed by dict

        //！他不是向前构造的，是一直向后构造

        for(int i=0; i<len; i++){
            for(int j=0;j<=i; j++){
                String sub = s.substring(j,i+1);
                if(set.contains(sub) && ( j==0 || dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }
}
