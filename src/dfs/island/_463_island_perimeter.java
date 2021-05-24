package dfs.island;

/**
 * Warrior to build this town
 *
 * 到边界或水池，我才计算周长，
 *
 * > 已经访问过就  grid[x][y] = -1 告诉我只是池子内部，不用算周长的
 *
 * 4/3/21.
 */
public class _463_island_perimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    res += dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y){
        if(x< 0 || x>= grid.length || y<0 || y>=grid[0].length || grid[x][y] == 0) return 1;
        if(grid[x][y] == -1) return 0;
        grid[x][y] = -1;
        return dfs(grid,x+1,y)+dfs(grid,x-1,y)+dfs(grid,x,y+1)+dfs(grid,x,y-1);
    }
}
