package backtracking.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 拿出来，再放回去，但不理解：
 *
 * 动规，递归，backtrack 的区别
 *
 *
 * 1。backtrack用了一个很巧妙的，单一行的验证：
 *   for(int i = 0; i < board.length; i++) {
         if(validate(board, i, colIndex)) {
             board[i][colIndex] = 'Q';
             dfs(board, colIndex + 1, res);
             board[i][colIndex] = '.';
         }
      }
 *
 * 2。记住那个放射状的validate 图 => if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
 *
 * |- * * *|
 * |* * Q *|
 * |- * * *|
 * |* - * -|
 *
 * 6/29/20.
 */
public class _51_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<List<String>>();
        if(n <= 0){
            return res;
        }
        char[][] board = new char[n][n];
        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args){
        _51_N_Queens solution = new _51_N_Queens();

        List<List<String>> test = solution.solveNQueens(5);
        System.out.println(solution.solveNQueens(5));
    }
}
