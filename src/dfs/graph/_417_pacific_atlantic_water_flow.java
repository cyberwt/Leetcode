package dfs.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从两边，流入
 *
 * dfs
 * -- 设一个height ，帮助比较，该点是否可用
 * dfs(matrix,i,0,pVisited,Integer.MIN_VALUE);
 * -- 从两边入手，辅助boolean[] aVisited pVisited
 * -- res.add(new int[] {i, j}); (res.add(list))
 * 优化
 * 1。主函数不用判断visited, dfs自会判断
 * 2。for(int[]d:dir){
      dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
     } 更简洁
 * T: O(M*N) S:O(M ot N as stack recursion)
 *
 *
 *
 * bfs （没写）
 * 与以往不同的是，不必在for循环里进行操作，因为node已经被加进去了
 * T: O(M*N) S:O(M * N)
 *
 *
 *
 * 1/17/21.
 */
public class _417_pacific_atlantic_water_flow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> list = new LinkedList<>();
        if(matrix==null || matrix.length == 0){
            return list;
        }
        int m=matrix.length, n= matrix[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        for(int i=0;i<m;i++){
            if(!pVisited[i][0]){
                dfs(matrix,i,0,pVisited,Integer.MIN_VALUE);
            }
            if(!aVisited[i][n-1]){
                dfs(matrix,i,n-1,aVisited,Integer.MIN_VALUE);
            }
        }

        for(int j=0; j<n; j++){
            if(!pVisited[0][j]){
                dfs(matrix,0,j,pVisited,Integer.MIN_VALUE);
            }
            if(!aVisited[m-1][j]){
                dfs(matrix,m-1,j,aVisited,Integer.MIN_VALUE);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pVisited[i][j] && aVisited[i][j]){
                    // complexity
                    List<Integer> tem = new LinkedList<>();
                    tem.add(i);
                    tem.add(j);
                    list.add(tem);
                }
            }
        }
        return list;
    }

    public void dfs(int[][] matrix, int x, int y, boolean[][] visited, int val){

        // error 1. don't continue, return for function
        if(x<0 || y<0 || x>=matrix.length || y>= matrix[0].length || visited[x][y] || matrix[x][y] < val){
            return;
        }

        visited[x][y] = true;
        dfs(matrix,x-1,y,visited,matrix[x][y]);
        dfs(matrix,x+1,y,visited,matrix[x][y]);
        dfs(matrix,x,y-1,visited,matrix[x][y]);
        dfs(matrix,x,y+1,visited,matrix[x][y]);

    }

    int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic2(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i=0; i<n; i++){ //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int i=0; i<m; i++){ //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

}
