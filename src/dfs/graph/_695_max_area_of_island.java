package dfs.graph;

/**
 * N:
 * > 其实是改变了原数组，从1变0 -> visited[][] 其实更好
 * > 写出bug
 * 其实是需要
 * area = dfs(grid,x+1,y,area) 来代入计算的
 * or area[0] reference based,来进行全局变换
 * > 复杂度
 * T:O(V+E) = O(M*N)
 *
 *
 * 1/14/21.
 */
public class _695_max_area_of_island {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length == 0){
            return 0;
        }
        // can I modify the
        int area = 0;
        for(int i=0; i< grid.length ;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    // int tem = bfs(grid, i,j);
                    int tem = dfs(grid,i,j,0);
                    area = Math.max(area, tem);
                }
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int x, int y, int area){
        if(x<0 || y< 0 || x>=grid.length || y>= grid[0].length || grid[x][y] == 0){
            return area;
        }
        grid[x][y] = 0;
        area++;
        area = dfs(grid,x+1,y,area);
        area = dfs(grid,x-1,y,area);
        area = dfs(grid,x,y+1,area);
        area = dfs(grid,x,y-1,area);
        return area;
    }

    private int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public int maxAreaOfIsland2(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int x, int y, boolean[][] visited){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] != 1){
            return 0;
        }
        int res = 1;
        visited[x][y] = true;
        for(int[] dir : directions){
            int newX = x + dir[0];
            int newY = y + dir[1];
            res += dfs(grid, newX, newY, visited);
        }
        return res;
    }
}
