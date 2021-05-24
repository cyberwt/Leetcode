package dfs.island;

/**
 * 1. 如果要限定闭环island =>  grid[i][j] == 0 && dfs(grid,i,j)
 *
 * 2. 且潜入关系是 & 而非 &&
 * =>  dfs(grid,x,y+1) & dfs(grid,x,y-1) & dfs(grid,x+1,y) & dfs(grid,x-1,y)
 *
 * 4/3/21.
 */
public class _1254_number_of_closed_islands {
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int res =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0 && dfs(grid,i,j)){
                    res++;
                }
            }
        }
        return res;
    }


    public boolean dfs(int[][] grid, int x, int y){
        if(x< 0 || y<0 || x>= grid.length || y >= grid[0].length){
            return false;
        }
        if(grid[x][y] == 1) return true;
        grid[x][y]=1;
        return dfs(grid,x,y+1)&
                dfs(grid,x,y-1)&
                dfs(grid,x+1,y)&
                dfs(grid,x-1,y);
    }

}
