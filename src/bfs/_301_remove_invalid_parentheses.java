package bfs;

import java.util.*;

/**
 * M1: BFS
 * BFS用了 queue 和 hashset 去看到底有没有 被visited
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
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);
        //flag要在loop 外，一旦是变了
        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
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
