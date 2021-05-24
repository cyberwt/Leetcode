package backtracking.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 理解了dfs:
 * > 1. 不断记录 left, right
 * 还有其中的翻转
 *  他是用stack 记录要移动 '(' or ')'
 *  然后判断 if(stack's relationship with 0)
 *  重新调用 dfs, 记住下一个
 *
 *  if(stack > 0) dfs(res, s, left, right, pos)
 *  if(stack < 0) dfs(res, s.toReverse, 0 , 0, new char[]{'(', ')'})
 *
 *  > 2.有一个重用dfs的逻辑非常巧妙, reverse
 *
 *
 *
 *  3. 去重！ 很重要
 *  if (c != pars[1]) continue;
    if (left > 1 && s.charAt(left) == s.charAt(left - 1)) continue;
 *
 *
 *  4. 理解left 是记录舍掉那个坐标， right 是记录当前坐标
 *
 *  时间
 *  T:
 *  To generate one node it requires O(n) time from the string concatenation among other things. So roughly O(nk). Accurately O(nm) where m is the total "number of recursive calls" or "nodes in the search tree".
 *  Then you need to relate m to n in the worst case.
 *  S:O(N)
 *
 *
 *
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
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, 0, res, new char[]{'(', ')'});
        return res;
    }

    private void helper(String s, int left, int right, List<String> res, char[] pars) {
        int stack = 0;
        int n = s.length();
        for (; right < n; right++) {
            char c = s.charAt(right);
            if (c == pars[0]) {
                stack++;
            } else if (c == pars[1]) {
                stack--;
            }

            if (stack < 0) break;
        }

        if (stack < 0) {
            for (; left <= right; left++) {
                char c = s.charAt(left);
                if (c != pars[1]) continue;
                if (left > 1 && s.charAt(left) == s.charAt(left - 1)) continue;
                helper(s.substring(0, left) + s.substring(left + 1), left, right, res, pars);
            }
        } else if (stack > 0) {
            helper(new StringBuilder(s).reverse().toString(), 0, 0, res, new char[]{')', '('});
        } else {
            res.add(pars[0] == '(' ? s : new StringBuilder(s).reverse().toString());
        }
}

