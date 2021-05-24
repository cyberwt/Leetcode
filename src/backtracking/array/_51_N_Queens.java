package backtracking.array;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *> 1. col 是每次判断时不动的点
 *
 *
 *
 *
 * 4/1
 *
 *
 * 半刷
 * >1. dfs方程
 * dfs(board, res, colIndex)
 * 里面写错了，动的是， 跟i没关系，姐姐: dfs(board, res, colIndex+1) 并不是全能公式里的一种
 * >2. 理解共线方程 点斜式: y2-y1 = k(x2-x1) k=+-1
 * >复杂度：
 * Time complexityO(N!). There is N possibilities to put the first queen,
 * not more than N (N - 2) to put the second one,
 * not more than N(N - 2)(N - 4) for the third one etc.
 * In total that results in O(N!) time complexity.
   Space complexity : O(N^2) to keep an information about diagonals and rows.
 *
 *
 *
 * 1/24/21 -
 *
 * 二刷 7/31 ，看着提醒
 * 1/ 没完全理解这种构建方法，
 * 单层循环每一层！
 * 然后-valid 同层different position
 * 近出 再放不同的位置
 *
 * 2/ 为什么会同线
 *   点斜式: y2-y1 = k(x2-x1)
 *
 *    x + j == y + i || x + y == i + j || x == i
 *
 *    x-i/y-j = 1
 *    x-i/j-y = 1    由图可知，截距是横为 +-1 的
 *
 * 3/ 最后构造construct list:  String s= new String(board[i]) 没写好;
 *
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
