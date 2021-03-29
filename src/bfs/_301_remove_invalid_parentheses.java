package bfs;

import java.util.*;

/**
 *
 * 理解stack
 *
 * 3/20
 *
 * bfs 根据自己的解，我想出了优化，在算substring 之前,加一句 if(res.size() == 0)
 * T:O(N*2^n)
   S:O(N)
 *
 *
 * 3/16/21
 *
 * DFS 设的left, right ,就默认取出他们，会是最优的解
 *
 *
 *
 *  BFS 可以bug almost free
 *
 *  T:O(n*2^n) S:O(1)
 *  理解为：
 *  Search space is as a power subset of the original string.
 *  So it includes all possible substrings from 0 character to N(number of chars in the input string) characters.
 *  So the possibilities are 2^n.
 *  (we either pick a character or don't pick it)
 *  For each subset we check if it is a valid string so it becomes n*(2^n)
 *
 *
 *  21/3/5
 *
 *
 * DFS:
 * E
 * >E1: CC 时，确认一下，空字符串 算不算 res
 * >E2: 因为有其它杂字符串出现，所以 要用if else
 * >>> left == 0 && right ==0
 * 整个思想就是，取left, right plus index determination 去决定
 *
 *  2/27/21
 *
 * - 滑铁卢，很难, 学习方法有问题，都忘了
 *
 * 理解两种方法!
 *
 *
 * DFS:
 *
 * dfs 第一次尝试，失败
 * 因为我干算的left, right, which is not right, 为什么要互相撤销呢，
 * 为的是，达到最小，为什么dfs 停住了呢，因为我已经找到了那个可以互怼的点了
 *
 *
 * 自己做的时候: 3个点没理解好:
 *  // 1. break 条件，得最小  [set left right difference, not the signle value]
 *  // 2.怎样 不重不漏:if(i!=index && s.charAt(i) == s.charAt(i-1))
 *  // 3. startIndex from i not 0, how
 *
 *
 *
 * 再做一遍：
 * 不能  dfs(str, i, res, left, --right); // 这样在下一个循环，right的值就不再一样了阿
 * 而是 dfs(str, i, res, left, right-1);
 *
 *
 * dfs 的时间复杂度，怎么计算:same as O(n*2^n) -- 2^n 种permutation * n means check isValid
 *
 * BFS:
 *
 * almost there:
 * > if(!set.contains(tem)) {
 *     // 2 ops
 *     set.add(tem);
 *     queue.add(tem);
 *   }
 * > 命名很乱，导致你操作的时候，拿哪个都会容易出错
 *
 *
 * 2/16/21
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
                // This is an optimization
                if (res.size() == 0) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) != '(' && cur.charAt(j) != ')') {
                            continue;
                        }
                        String tem = cur.substring(0, j) + cur.substring(j + 1);
                        // set 是在这里起作用的，not regular expression
                        if (!set.contains(tem)) {
                            set.add(tem);
                            queue.add(tem);
                        }
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
            // M1: 并不保证 此时是可以的: )()
            if (isValid(s))
            // M2: 一定存在一种可能，当left == 0 && right == 0 得到要找的 res
            return;
        }
        // M4: why it has a start from index, otherwise it must have unnecessary duplicate, like {""} or {"", ""}
        for (int i = start; i < s.length(); i++) {
            // M3: 是需要跳过重复字符的
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;//连续多个相同的括号只删除第一个
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String cur = s;
                // M2: 为什么是要有 index
                cur = cur.substring(0,i) + cur.substring(i+1);
                if (r > 0 && s.charAt(i) == ')') dfs(cur, i, l, r - 1, res);
                else if (l > 0 && s.charAt(i) == '(') dfs(cur, i, l - 1, r, res);
            }
        }
    }
}
