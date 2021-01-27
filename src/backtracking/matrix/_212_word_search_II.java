package backtracking.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. treenode 不一定要存值，直接一个string word ,然后判断child !=null
 * 2. 复杂度极高
 *  主方程里: for ^2
 *  子dfs里: 在四个方向
 * 3. p.word = null;
 *    board[x][y] ='*'
 * 两种 dedupe 方法
 *
 * 1/26
 *
 * 自己做一遍,with 结构优化，怎么实现tire的trieNode search and buildTire
 * T: O(m * n * wl * 4^wl) where m*n is the size of the board and
 * wl is the average length of the words in the list.
 * For this optimized approach, it becomes O(m * n * 4^wl).
 *
 * S: O(m*n)
 * T:O(m*n)
 * 1/23/21.
 */
public class _212_word_search_II {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
