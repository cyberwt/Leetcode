package dfs.words;

/**
 * Created by weitong on 4/11/21.
 */
public class _79_word_search {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }

        // dfs 会返回什么样类型的数据
        // 我的起始 dfs 要怎么定义
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board,word,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int x, int y){
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }

        if(index == word.length() -1 && board[x][y] == word.charAt(index)){
            return true;
        }

        // 来四个方向- 包围

        board[x][y] = '.';

        if(dfs(board,word,index+1,x+1,y) || dfs(board,word,index+1,x-1,y) || dfs(board,word,index+1,x,y+1) || dfs(board,word,index+1, x,y-1)){
            return true;
        }
        board[x][y] = word.charAt(index);

        return false;
    }
}
