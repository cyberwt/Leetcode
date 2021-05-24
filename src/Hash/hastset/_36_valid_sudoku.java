package Hash.hastset;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * M1: HashMap
 * 依据每一个rule的规则，做sanity check
 * T: O(3N) S:O(1) -- O(constant)
 *
 *
 * M2: HashSet
 * 定义自己的unique rule, so everything else fits in one rule check
 *
 * T:O(N) S:O(N)
 *
 * 6/11/20.
 */
public class _36_valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9 ){
            return false;
        }
        // Self define hashset rule
        HashSet<String> set = new HashSet<String>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                String str="(" + board[i][j] + ")";
                if(board[i][j] != '.'){
                    if(!set.add(str+i) || !set.add(j+ str) || !set.add((i/3)+str+(j/3))){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // M2

    public boolean isValidSudoku_2(char[][] board) {
        //判断每一行
        for (int i = 0; i < 9; i++) {
            if (!isValidRows(board[i])) {
                return false;
            }
        }
        //判断每一列
        for (int i = 0; i < 9; i++) {
            if (!isValidCols(i, board)) {
                return false;
            }
        }
        //判断每个小棋盘
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidSmall(i, j, board)) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isValidRows(char[] board) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : board) {
            if (c != '.') {
                if (hashMap.getOrDefault(c, 0) != 0) {
                    return false;
                } else {
                    hashMap.put(c, 1);
                }
            }
        }
        return true;
    }

    public boolean isValidCols(int col, char[][] board) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            char c = board[i][col];
            if (c != '.') {
                if (hashMap.getOrDefault(c, 0) != 0) {
                    return false;
                } else {
                    hashMap.put(c, 1);
                }
            }
        }
        return true;
    }

    public boolean isValidSmall(int row, int col, char[][] board) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[row + i][col + j];
                if (c != '.') {
                    if (hashMap.getOrDefault(c, 0) != 0) {
                        return false;
                    } else {
                        hashMap.put(c, 1);
                    }
                }
            }
        }
        return true;
    }
}
