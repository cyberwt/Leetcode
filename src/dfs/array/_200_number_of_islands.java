package dfs.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1/17/21
 * dfs bug free
 *
 *
 * 1.12.21
 * > bfs 其实并非要在level上做文章了， 直接类似与dfs, 放进queue里想当于过了一层
 *
 *
 *
 *
 * 10.25
 * 就是dfs,bfs的基础模版
 *
 * dfs可以在头上先判断，转制,再来4个dfs
 *
 * bfs可以把queue作为参数，也可以不做
 *
 * dfs: T:(m*n) 使用法1，先判断，动则，直接跳出去
 *
 * bfs: T(N^2)
 *
 * 9.24
 * 跳出条件拉了一个 grid[i][j] != '1'
 * 导致stackoverflow
 *
 * M2:
 * 最好是用visited[][] ，以防改原值
 * 在bfs里同样要判断
 * ！after dirs[][] 之后的跳出条件 if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0')
 * ！flip visited[i][j]
 *
 * 9.28
 * E2: 要先判断i,j 有没有越界，再判断 grid & visited
 *
 * E3: BFS: 必须在入队前 翻转！ visited[i][j]，否则 这个queue 堵在中间的，会被再次访问到
 *
 *
 * T:O(M*N) S:O(MN)
 *
 * DFS怎么比，潜下去
 *
 * Iterate数组，=》定义跳出天
 *
 * 8/22/20.
 */
public class _200_number_of_islands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        int count =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    //把岛变水
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        //  for (int[] dir : dirs)  DFS(grid, i + dir[0], j + dir[1], m, n);
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    // 坐标的题，就要判断是否越界， 没有dfs更好，作为优化解
    public void dfs(int x, int y, char[][] grid, boolean[][] visited){
        visited[x][y] = true;
        int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<4;i++){
            int x1 = x+pos[i][0];
            int y1 = y+pos[i][1];
            if(x1<0 || y1<0 || x1>=grid.length || y1>=grid[0].length){
                continue;
            }
            if(grid[x1][y1] == '1' && !visited[x1][y1]){
                dfs(x1,y1,grid,visited);
            }
        }
    }

    public int numIslands2(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }

        return count;
    }

    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0')
                    continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
