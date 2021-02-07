package backtracking.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Error:
 * 1.start index from 1 - length()
 *
 * 2.构建和理解函数是更难的， dfs(res,list,s)
 * 怎么去理解，不断回切s, 让substring 不断乡下拓展
 *
 *
 * 1/24/21
 *
 *  M1: backtrack
 *
 *  理解backtrack的思路，不局限于一直往里传i, 也可以是一个子字符串
 *   > 退出/边界 条件
 *   > 判断[0,index]  开始,add进去往下走，remove list.remove(list.size()-1)
 *   > 在下一个for循环里寻找可能
 *
 *  M2：dp 可以帮助实现优化
 *
 *  理解：是否是有效的palindrome
 *
 *
 *  为什么你用dfs(s, index, list,res) 没想出来，因为你没分好解，而且这个方法更好理解
 *
 *
 *  8/2/20
 */
public class _131_palindrome_partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        List<String> list = new LinkedList<>();
        backtrack(s,list,res);
        return res;
    }

    public void backtrack(String s, List<String> list, List<List<String>> res){
        if(s == null || s.length() == 0){
            res.add(new LinkedList<>(list));
        }

        for(int i=1; i<=s.length(); i++){
            String subString = s.substring(0, i);
            if(! isValid(subString)) continue;

            list.add(subString);
            String nextString = s.substring(i,s.length());
            backtrack(nextString, list,res);
            list.remove(list.size()-1);
        }
    }

    public boolean isValid(String s){
        int left =0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    // M2
    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int len=1; len<=s.length(); len++){
            for(int i=0; i<=s.length()-len; i++){
                int j = i+len-1;
                dp[i][j] = (s.charAt(i) == s.charAt(j))&& (len<3 || dp[i+1][j-1]);

            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

