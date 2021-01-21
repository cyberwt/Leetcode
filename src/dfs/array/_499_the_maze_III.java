package dfs.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * >没做，看别人写的
 * >>1.设置变量
 * dp[][] -> record level
 * dpPath[][] -> record direction path
 * >>2.after while jump
 * use this because of the hole:
 * if (!(row == hole[0] && col == hole[1])) {
      row -= dir[0][i];
      col -= dir[1][i];
      dist--;
    }

 * >>3.return dpPath[hole[0]][hole[1]].equals("z")? "impossible": dpPath[hole[0]][hole[1]];
 * >> 4.lexiographically order
 * (path.compareTo(dpPath[row][col]) < 0)
 *
 * if (dist <= dp[row][col]) {
     if (dist < dp[row][col]) {
         dp[row][col] = dist;
         dpPath[row][col] = path;
         // ！ lexicographically smaller ！
     } else if (path.compareTo(dpPath[row][col]) < 0) {
        dpPath[row][col] = path;
     }
     queue.offer(new int[]{row, col});
 }
 *
 * 1/18/21.
 */
public class _499_the_maze_III {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ball[0], ball[1]});
        int m = maze.length, n = maze[0].length;
        int[][] dir = new int[][]{{1, -1, 0, 0}, {0, 0, 1, -1}};
        String[] pa = new String[]{"d", "u", "r", "l"};
        // two variable: dp & dpPath
        // or give queue.add(ball[0],ball[1],dp_int, dpPath_string)
        int[][] dp = new int[m][n];
        String[][] dpPath = new String[m][n];
        for (int[] d: dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (String[] d: dpPath) {
            Arrays.fill(d, "z");
        }
        dp[ball[0]][ball[1]] = 0;
        dpPath[ball[0]][ball[1]] = "";
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = cur[0];
                int col = cur[1];
                String path = dpPath[row][col];
                int dist = dp[row][col];
                // path direction 每层 只搞一次！
                path += pa[i];
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != 1) {
                    if (row == hole[0] && col == hole[1]) {
                        break;
                    }
                    row += dir[0][i];
                    col += dir[1][i];
                    dist++;
                }
                if (!(row == hole[0] && col == hole[1])) {
                    row -= dir[0][i];
                    col -= dir[1][i];
                    dist--;
                }
                if (row == cur[0] && col == cur[1]) {
                    continue;
                }
                if (dist <= dp[row][col]) {
                    if (dist < dp[row][col]) {
                        dp[row][col] = dist;
                        dpPath[row][col] = path;
                        // ！ lexicographically smaller ！
                    } else if (path.compareTo(dpPath[row][col]) < 0) {
                        dpPath[row][col] = path;
                    }
                    queue.offer(new int[]{row, col});
                }
            }
        }
        return dpPath[hole[0]][hole[1]].equals("z")? "impossible": dpPath[hole[0]][hole[1]];
    }
}
