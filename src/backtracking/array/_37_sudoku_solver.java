package backtracking.array;

/**
 *
 * E:
 * 1.放 char for(char i = '1')
 * 2. isValid method 只检查 9 个格子么，不对的，
 * 应该 for(){
 *     if(board[i+ 9*(x/9)][y] == val) return false;
 * }
 * 3.最大的bug
 *
 * 应该 if(isValid()) first then
 *    put board[i][j] = val , 否则，恒不vaild
 *
 * 1/25/21
 *
 * 新建boolean helper(board),而非调用旧的
 * E:
 * 1. !运用的是这个判定方法：
 * if(isValid(board, i, j, c)){
     board[i][j] = c; //Put c for this cell
      // 是else board[i][j] = '.'  不一定非要转的
     if(solve(board))
            return true; //If it's the solution return true
     else
     board[i][j] = '.'; //Otherwise go back
   }
   2.  return 值也值得关注，
 在外层是return false 因为没有变换成
 最外层是true,表示真的转换了

 * Complexity:
 * T:O(9^m)
 * (m represents the number of blanks to be filled in),
 * since each blank can have 9 choices
 *
 * S:O(1)
 *
 *
 *
 * 1/24/21
 *
 * 理解 验证有效的那三个表达式
 *
 * Backtrack
 *
 * 如果是[.]， if valid in 3 condtions, valid 变
 * 要不然回去
 *
 * 问题是，为什么最后return ,会return 的值就是期待值
 *
 *
 * 6/12/20.
 */
public class _37_sudoku_solver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        solve(board);
        return;
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            // rowIndex: 3*(row/3)   colIndex: 3*(col/3)

            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

//    public static void main(String[] args){
//        _37_sudoku_solver solution = new _37_sudoku_solver();
//
//        List<List<String>> test = solution.solveSudoku([[12],[],[]]);
//        System.out.println(solution.solveNQueens(5));
//    }

}
