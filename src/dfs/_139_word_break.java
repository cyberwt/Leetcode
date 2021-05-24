package dfs;

import java.util.HashSet;
import java.util.List;

/**
 * M1:
 * 用一个hashset.add(index), 妙趣了，还要检查i位置的重复计算  as word break two
 *
 * dsf(s, index, wordDict, set)
 *
 *  Error:
 * 1. recorder 是存s 中index的，证明前面已经无条件访问过了
 * 2. 1，2语句不能合并
 * if(dfs(s,set,i,recorder)){
 return true;
 }
 3.  然后 recorder.add(i);
  一波一波向里走，也是一个 T:O(n^2)
 *
 *
 *
 * M2:
 * 1. Dp  record if the maps contains [i,j),
 * if dp[i] true and s.substring(i,j) => means dp[j] true
 * 2. 多开一个空间，这样比的话，就更好理解，不用对dp[0] 有特殊判断
 *  T:O(N^2) N is the length of the string
 *  S:O(N) opens a arr
 *
 *  优化：
 *  M2内循环剪枝，直走word length 长度
 *  j(new) = i+ word.length()
 *
 *  ! 但前提条件是 if(dp[i]  && i+ word.length() <= len) 否则直接跳出
 *  是<= ！
 *  T: O(N*m) m is the length of the wordDict
 *
 *
 * 4/6/21
 *
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
        if(s == null || s.length() == 0){
            return false;
        }
        // sequence can only use one or mutiple words but needs connected

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        HashSet<String> set = new HashSet<String>(wordDict);
        dp[0] = true; // as a basic arr
        for(int i=0 ;i < s.length() ;i++){
            // can't get j from this array
            for(int j=i+1; j<= s.length(); j++){
                String cur = s.substring(i,j);
                if(dp[i] && set.contains(cur)){
                    dp[j] = true;
                }
            }
        }

        return dp[len];
    }
}
