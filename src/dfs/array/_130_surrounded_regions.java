package dfs.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * dfs
 * recursive 的方法，自己优化一下，需不需要visited[i][j], 肯定是更快的
 *
 * bfs
 * don't need a point class, give a queue.add(new int[]{x,y})
 * still use a queue, point is: do I need a visited[][] -- no.
 *
 * I've already transfer the point value from 'O' to 'B', will not replace this value
 *
 * 1/20/21
 *
 * dfs
 * 其实有两种，递归，非递归要continue
 * 注意的是，在写非递归的时候，我们每次查看 stack 顶，但是并不出 stack，直到这个位置上下左右都搜索不到的时候出 Stack。
 *
 * bfs
 *
 * bfs 不需要continue，且入栈后，必须立马标记
 * queue.add(new Pos(current.i - 1, current.j));
   board[current.i - 1][current.j] = '#';

 T:O(N^2) S:O(1)

 * dfs 非递归的时候我们用 stack 来记录状态，而 bfs 非递归，我们则用队列来记录状态。
 * 和 dfs 不同的是，dfs 中搜索上下左右，只要搜索到一个满足条件，我们就顺着该方向继续搜索，
 * 所以你可以看到 dfs 代码中，只要满足条件，就入 Stack，然后 continue 本次搜索，进行下一次搜索，直到搜索到没有满足条件的时候出 stack。
 * 而 bfs 中，我们要把上下左右满足条件的都入队，所以搜索的时候就不能 continue。大家可以对比下两者的代码，体会 bfs 和 dfs 的差异。

还有一种union-find:
 https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
 *
 * 10/25/20
 *
 * board上 不会改变的只有边界，在边界上不断递归dfs ,用第三个变量去 限定，
 * 一定是不变的值 '*'
 *
 * 最后post-handle 结束预处理
 *
 * 8/4/20.
 */
public class _130_surrounded_regions {
    public void solve2(char[][] board) {
        if(board == null || board.length <=2){
            return;
        }
        // decreate two times for refresh
        int row=board.length-1, col=board[0].length-1;
        for(int i=0; i<=row; i++){
            for(int j=0; j<=col; j++){
                if( (i==0 || j ==0 ||  i == row || j ==col) && board[i][j] == 'O'){
                    dfs(i,j,board);
                    // bfs(i,j,board);
                }
            }
        }


        for(int i=0; i<=row;i++){
            for(int j=0;j<=col;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }

            }
        }


        return;
    }


    // 这个判断很重要，边界上就是要标'*'
    public void dfs(int i, int j, char[][] board){
        // 找一遍就行了，别再回去找一遍了
        if(i<0 || j<0 || i> board.length-1 || j>board[0].length-1 || board[i][j] == 'X' || board[i][j] == '*'){
            return;
        }
        board[i][j] = '*';
        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }

    // bfs
    class Point{
        int i;
        int j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public  void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int rows = board.length, columns = board[0].length;
        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == columns - 1) && board[i][j] == 'O') {
                    // here is bfs key
                    Queue<Point> queue = new LinkedList<>();
                    board[i][j] = 'B';
                    queue.offer(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = direction[k][0] + point.i;
                            int y = direction[k][1] + point.j;
                            if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O') {
                                board[x][y] = 'B';
                                queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
            }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'B')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }

    }
}
