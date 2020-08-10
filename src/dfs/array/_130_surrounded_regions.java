package dfs.array;

/**
 * board上 不会改变的只有边界，在边界上不断递归dfs ,用第三个变量去 限定，
 * 一定是不变的值 '*'
 *
 * 最后post-handle 结束预处理
 *
 * 8/4/20.
 */
public class _130_surrounded_regions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        if(board.length <2 || board[0].length <2){
            return;
        }

        // handle top & bottom row

        int m=board.length, n=board[0].length;


        for(int i=0; i<m; i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if(board[i][n-1] == 'O'){
                dfs(board,i,n-1);
            }
        }

        // handle left & right column

        for(int j=0; j<n;j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j);
            }
            if(board[m-1][j] == 'O'){
                dfs(board,m-1,j);
            }
        }

        // post deal with matrix
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == '*'){
                    board[i][j] ='O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
        return;

    }


    public void dfs(char[][] board, int x, int y){
        if(x<0 || y<0 || x>=board.length || y>= board[0].length){
            return;
        }
        int m = board.length, n=board[0].length;
        if(board[x][y] == 'O'){
            board[x][y] = '*';
        }
        if(y>=1 && board[x][y-1] == 'O'){
            dfs(board,x,y-1);
        }

        if(x>=1 && board[x-1][y] == 'O'){
            dfs(board,x-1,y);
        }
        //x+1<m
        if(x<m-1 && board[x+1][y] == 'O'){
            dfs(board,x+1,y);
        }

        if(y<n-1 && board[x][y+1] == 'O'){
            dfs(board,x,y+1);
        }
        return;
    }
}
