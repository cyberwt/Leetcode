package dfs.array;

import java.util.LinkedList;

/**
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

    class Point {
        int x,y;
        public Point(int _x, int _y) {x=_x;y=_y;}
    }

    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        int m=maze.length, n=maze[0].length;
        if (start[0]==destination[0] && start[1]==destination[1]) return true;
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited=new boolean[m][n];
        LinkedList<Point> list=new LinkedList<>();
        visited[start[0]][start[1]]=true;
        list.offer(new Point(start[0], start[1]));
        while (!list.isEmpty()) {
            Point p=list.poll();
            int x=p.x, y=p.y;
            for (int i=0;i<4;i++) {
                int xx=x, yy=y;
                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0) {
                    xx+=dir[i][0];
                    yy+=dir[i][1];
                }
                xx-=dir[i][0];
                yy-=dir[i][1];
                if (visited[xx][yy]) continue;
                visited[xx][yy]=true;
                if (xx==destination[0] && yy==destination[1]) return true;
                list.offer(new Point(xx, yy));
            }
        }
        return false;

    }
}
