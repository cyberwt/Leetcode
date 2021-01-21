package dfs.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 理解rolling - stop 的意义
 *
 * while(x+pos[i][0]>= 0 && x+pos[i][0]<m && y+pos[i][1]>=0 && y+pos[i][1]<n && maze[newX][newY] != '1' ){
 *     x += pos[i][0];
 *     y += pos[i][1];
 * }
 *
 * then develop dfs & bfs
 *
 * 1/18/21
 *
 * M1: DFS
 *
 * 开始的思路是loop到这个位置就行，+ hashset
 * > 不对，
 * while(dx+pos[0]>=0 && dx+pos[0]<maze.length && dy+pos[1]>=0 && dy+pos[1]<maze[0].length && maze[][]!='1'){
 *     dx += pos[0];
 *     dy += pos[1];
 * }
 * 一直滚到能停的位置的位置才有资格和des比较
 * > hashset 写起来容易，但慢了
 *
 * 大套子你是有的
 *
 * if(visited) return false;
 * visited
 * if(start == des) return true;
 *
 * for(int[] pos:post){
 *     while(pre_process)
 *     // 合格了继续往下, 并能够即时返回 true flag
 *     if(dfs){
 *        return true;
 *     }
 *
 * }
 *    return false;
 *
 * M2: BFS
 * >class Point
 * >用 point 加入到queue里
 *
 *
 *
 * 结合理解dfs，我是向宽度进发
 * https://leetcode.com/problems/the-maze/discuss/97071/Easy-understanding-Java-bfs-solution.
 *
 *
 * 8/25/20.
 */
public class _490_the_maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }
        //boolean[][] or hashset to say if this point been visited
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        boolean flag = dfs(maze,start,destination,visited);
        return flag;
    }
    int[][] pos = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean dfs(int[][] maze, int[] start, int[] end, boolean[][] visited){
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == end[0] && start[1] == end[1]) {
            return true;
        }

        visited[start[0]][start[1]] = true;
        for(int i=0;i<pos.length; i++){
            int dx = start[0];
            int dy = start[1];
            while(dx+pos[i][0]>=0 && dx+pos[i][0]<maze.length && dy+pos[i][1]>=0 && dy+pos[i][1]<maze[0].length && maze[dx+pos[i][0]][dy+pos[i][1]] !=1){
                dx = dx+pos[i][0];
                dy = dy+pos[i][1];
            }
            // do we need back track to find a best solution? No need, seems like
            if(dfs(maze,new int[]{dx,dy},end,visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            int[][] move = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            for (int[] mo : move) {
                int x = cur[0], y = cur[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += mo[0];
                    y += mo[1];
                }
                // Back to validate point.
                x -= mo[0];
                y -= mo[1];
                // Adding new start point.
                if(!visited[x][y]){
                    visited[x][y] = true;
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return false;
    }
}
