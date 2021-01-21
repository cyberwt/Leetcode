package bfs;

import java.util.*;

/**
 *
 * BFS:
 * E:
 *
 * ！我要先在 for循环外 先判断isValid(cur) ---
 * 再做他的子字符串(tem)， 否则，会漏掉cur 的情况
 *
 *

 On the first level, there's only one string which is the input string s,
 let's say the length of it is n, to check whether it's valid, we need O(n) time.
 On the second level, we remove one ( or ) from the first level,
 so there are C(n, n-1) new strings, each of them has n-1 characters, and for each string,
 we need to check whether it's valid or not,
 thus the total time complexity on this level is (n-1) x C(n, n-1).
 Come to the third level, total time complexity is (n-2) x C(n, n-2),
 so on and so forth...

  Finally we have this formula:

  T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1)

 * DFS:
 * 用了两种方式avoid stackoverflow
 * > if(i!=start && s.charAt(i-1) == s.charAt(i)) continue;
 *
 * > if(left > 0 && s.charAt(i) == '(')
 *
 *
 * T:O(nm) where m is the total "number of recursive calls" or "nodes in the search tree".
 * Then you need to relate m to n in the worst case.
 *
 * 1/17/21
 *
 * BFS: How to generate/(go to) next level
 *
 *
 * 1/13/21
 *
 * M1: BFS
 * BFS用了 queue 和 hashset 去看到底有没有 被visited
 *
 *
 * M2: DFS
 * ! dfs(list, int left_bracket, int right_bracket, int index)
 * 2. 很重要！ 否则有duplicate
 *  if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;//连续多个相同的括号只删除第一个
 *
 *
 * 8/29/20.
 */
public class _301_remove_invalid_parentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(s);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(res.size()!=0) return res;
            for(int i=0; i<size;i++){
                String cur = queue.poll();
                if(isValid(cur)){
                    res.add(cur);
                }
                for(int j=0; j<cur.length(); j++){
                    if(cur.charAt(j) != '(' && cur.charAt(j) != ')'){
                        continue;
                    }
                    String tem = cur.substring(0,j)+cur.substring(j+1);
                    if(!set.contains(tem)){
                        set.add(tem);
                        queue.add(tem);
                    }
                }
            }
        }
        return res;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && --count <0) return false;
        }

        return count == 0;
    }

    public List<String> removeInvalidParentheses2(String s) {
        //统计需要删除多少个左右括号
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') l++;
            else if (s.charAt(i) == ')') {
                if (l > 0) l--;//此时有左括号可以和右括号匹配
                else r++;//此时右括号落单
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, 0, l, r, res);
        return res;
    }

    private void dfs(String s, int start, int l, int r, List<String> res) {
        //递归终止条件，没有要删除的左括号和右括号
        //此时要判断字符串是否合法，合法的话就加入结果中
        if (l == 0 && r == 0) {
            if (isValid(s)) res.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;//连续多个相同的括号只删除第一个
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String cur = s;
                cur = cur.substring(0,i) + cur.substring(i+1);
                if (r > 0 && s.charAt(i) == ')') dfs(cur, i, l, r - 1, res);
                else if (l > 0 && s.charAt(i) == '(') dfs(cur, i, l - 1, r, res);
            }
        }
    }
}
