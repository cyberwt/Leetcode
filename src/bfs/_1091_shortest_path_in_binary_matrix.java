package bfs;

/**
 *
 * continue the search
 *
 * if(XNew>=0 && XNew < m && YNew >=0 && YNew < n && !visited[XNew][YNew] && grid[XNew][YNew] == 0){
      queue.add(new int[]{XNew, YNew});
      visited[XNew][YNew] = true;
   }
 *
 *
 * 1/17/21
 *
 * 典型的 bfs, 建queue，标记
 *
 * 在结束完，本层(this width)的操作之后，再在 res+1
 *
 *
 * 1/11/21.
 */


import java.util.LinkedList;
import java.util.Queue;

public class _1091_shortest_path_in_binary_matrix {
    private int[][] dir = new int[][]{{0,1},{1,1},{0,-1},{-1,-1},{-1,0},{-1,1},{1,0},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0,0});
        // why visited need to be here, has to be bind here
        visited[0][0] = true;
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                int[] pos = queue.poll();
                // when I need to make the mark
                if(pos[0] == m-1 && pos[1] == n-1){
                    return res+1;
                }
                int xPos = pos[0], yPos = pos[1];
                for(int j=0; j<8; j++){
                    int XNew = xPos + dir[j][0];
                    int YNew = yPos + dir[j][1];

                    if(XNew>=0 && XNew < m && YNew >=0 && YNew < n && !visited[XNew][YNew] && grid[XNew][YNew] == 0){
                        queue.add(new int[]{XNew, YNew});
                        visited[XNew][YNew] = true;
                    }
                }

            }
            res++;
        }
        return -1;
    }
}
