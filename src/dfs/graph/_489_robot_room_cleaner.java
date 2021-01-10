package dfs.graph;

import java.util.HashSet;

/**
 * 真正在 metrics上怎么走的
 *
 * dfs + 方向
 *
 * dfs: go with one direction, if 4 dirs all blocked, go back to where it come from
   also, dfs should record visited node, since it's a backtrack, need a way to record visited node

---- 思路

  1. Assume I start from [0][0], actually I can start whatever I like,always follow with the same directions,to continue clean
  2. how to construct dfs
  (current x, current y, current direction, visited)
 > current location,
 > visited map
 > current direction
  3. how to represent direction?
location diff:
 int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}}
 index = (index+1) % 4

---- 为什么

 a. clean & add 是一组, 为什么一定要放在dfs的头呢
 因为不能放在for loop 里面， 否则，跟(x,y) 相关的操作，执行次数翻倍

 b.最后turnRight 是在二维空间里dfs的一种方向调节技巧

---- 复杂度

 𝐓𝐢𝐦𝐞 𝐂𝐨𝐦𝐩𝐥𝐞𝐱𝐢𝐭𝐲: O(4 ^ (N - X)) where N is the total number of cells in the grid and X is the number of obstacles.
 Why is it to the power of 4? Because for each valid cell, we are exploring in all 4 directions i.e Top, Left, Bottom and Right.

 𝐒𝐩𝐚𝐜𝐞 𝐂𝐨𝐦𝐩𝐥𝐞𝐱𝐢𝐭𝐲:O(N - X) since we need a HashSet of size N - X, to keep track of the cells that are already cleaned.


 ! 之前根本没想到的：
 dirs 的表达 需要和旋转的方向需要保持一致， 数组是一个连续数组


 *
 *
 *
 *
 * --- 10.25, 两个月以后，看别人的总结，要在点上，ok?
 *
 *
 * 新题型:
 * 1.相对坐标，就可以放到 hashset 里去
 * 设置坐标初始值 private static int[][] pos - ! 这个pos 是{1,0} 一位构建，且！！ordered position
 *
 * 2.robot 需要不停的转向，来确定位置
 *  dfs 的构造：
 *  2.1 robot.clean
 *  2.2 set.add(pos);
 *  2.3 每个位置往下走四次
 *      for(each of the clockwise newPos){
 *          int newX , newY
 *          if(!set.contains && robot.clean ){
 *
 *              // 1. why need my newPos, 保证我的新朝向是对的,不能还是每个点都是先uptowds,
 *              的顺应我的上一个的位置，就是newPos
 *
 *              dfs(newX, newY, my newPos, set);
 *              // 2. backtrack
 *              backtrack 我结束向下走的
 *
 *          }
 *          3. //下一个方向,下一个 clock wise的位置
 *          turnRight();
 *
 *      }
 *

 *
 * 8/23/20.
 */
public class _489_robot_room_cleaner {

    interface Robot{

        public boolean move();
        public void turnLeft();
        public void turnRight();
        public void clean();
    }


    private static int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
    public void cleanRoom(Robot robot) {
        HashSet<String> set = new HashSet<String>();
        dfs(0,0,0,set,robot);
    }


    public void dfs(int x, int y, int newPos, HashSet<String> set,Robot robot){
        //clean && add set
        robot.clean();
        set.add(x+"->" + y);
        for(int i=newPos; i<newPos+4; i++){
            int newX = x+ pos[i%4][0];
            int newY = y+ pos[i%4][1];
            if(!set.contains(newX + "->" + newY) && robot.move()){
                dfs(newX,newY,i%4,set,robot);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }

    }
}
