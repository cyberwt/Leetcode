package dfs.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * dfs, 不用backtrack，所以比较费时,
 * 比较的时候，直接： 4个边界 + 当前值比较
 * if(x1>=0 && x1<rooms.length && y1>=0 && y1<rooms[0].length && rooms[x][y]+1<= rooms[x1][y1])
 *
 * > T:O(4^N) s:O(1)
 *
 * bfs, 先加点，再while 出queue
 *
 * 二者为什么不一样？？
 *
 * T:O(2^n), S:O(N) for bfs T:O(4^n), S:O(1) for dfs
 *
 * 10/25/20.
 */
public class _286_walls_and_gates {


    public void wallsAndGates(int[][] rooms) {
        //start from initial block
        if(rooms == null || rooms.length == 0){
            return;
        }
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    dfs(i,j,rooms);
                }
            }
        }
    }
    private int[][] pos = {{1,0},{0,-1},{-1,0},{0,1}};
    // bfs可以递归么,每格递归，没必要
    public void dfs(int x, int y, int[][] rooms) {
        for (int i = 0; i < 4; i++) {
            int x1 = x + pos[i][0];
            int y1 = y + pos[i][1];
            if (x1 >= 0 && x1 < rooms.length && y1 >= 0 && y1 < rooms[0].length && rooms[x][y] + 1 <= rooms[x1][y1]) {
                rooms[x1][y1] = rooms[x][y] + 1;
                dfs(x1, y1, rooms);
            }
        }
    }

    public void wallsAndGates2(int[][] rooms) {
        //start from initial block
        if(rooms == null || rooms.length == 0){
            return;
        }

        // queue里可以放 int[] 么
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int pos[][] = {{1,0},{-1,0},{0,-1},{0,1}};
        // 为什么这个可以是bfs, 跟dfs有什么区别么？
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int i=0; i<4;i++){

                int x1 = point[0] + pos[i][0];
                int y1 = point[1] + pos[i][1];
                if(x1<0 || x1>=rooms.length || y1<0 || y1>=rooms[0].length || rooms[point[0]][point[1]]+1 >rooms[x1][y1]){
                    continue;
                }
                rooms[x1][y1] = rooms[point[0]][point[1]]+1;
                queue.add(new int[]{x1,y1});
            }
        }
        return;

    }

}
