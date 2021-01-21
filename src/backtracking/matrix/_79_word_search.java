package backtracking.matrix;

/**
 * M1:
 * 1.跟dfs的关系是什么
 * 多了回溯的步骤
 * check[x][y] = true;
   if(dfs(board,check,word,index+1,x+1,y) || dfs(board,check,word,index+1,x-1,y) || dfs(board,check,word,index+1,x,y+1) || dfs(board,check,word,index+1,x,y-1)){
       return true;
   }
   check[x][y] = false;
 *
 * M2:
 *
 * 1/22/21
 *
 *  每一个格子里的每一个数，我都会做 dfs, 并且用额外空间 boolean[][] 去检测到底有没有被visited
 *
 *  定义好，每一个溢出条件
 *  M2: bit的优化
 *  直接
 *
 *  7/8/20.
 */
public class _79_word_search {
    public boolean exist(char[][] board, String word) {
        //怎么保证他不会往回走？
        // 怎么进行上下左右的判定
        if(board==null || board.length == 0 || board[0].length == 0){
            return false;
        }
        boolean[][] check = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean sign = dfs(board, check, word,0,i,j);
                if(sign == true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] check, String word, int index,int x,int y){
        if(x<0 || x>board.length-1 || y<0 || y>board[0].length -1){
            return false;
        }

        if(check[x][y] == true || board[x][y] != word.charAt(index)){
            return false;
        }

        // 真正true的条件
        if(index== word.length()-1){
            return true;
        }

        check[x][y] = true;


        if(dfs(board,check,word,index+1,x+1,y) || dfs(board,check,word,index+1,x-1,y) || dfs(board,check,word,index+1,x,y+1) || dfs(board,check,word,index+1,x,y-1)){
            return true;
        }

        check[x][y] = false;
        return false;
    }



    // M2
    public boolean exist2(char[][] board, String word) {
        //怎么保证他不会往回走？
        // 怎么进行上下左右的判定
        if(board==null || board.length == 0 || board[0].length == 0){
            return false;
        }

        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean sign = dfs(board, word,0,i,j);
                if(sign == true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index,int x,int y){
        if(x<0 || x>board.length-1 || y<0 || y>board[0].length -1){
            return false;
        }

        if( board[x][y] != word.charAt(index)){
            return false;
        }

        if(index== word.length()-1){
            return true;
        }

        board[x][y] ^= 256;


        if(dfs(board,word,index+1,x+1,y) || dfs(board,word,index+1,x-1,y) || dfs(board,word,index+1,x,y+1) || dfs(board,word,index+1,x,y-1)){
            return true;
        }
        board[x][y] ^= 256;
        return false;
    }

}
