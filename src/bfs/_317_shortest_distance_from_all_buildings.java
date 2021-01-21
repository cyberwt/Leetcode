package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 大致知道怎么做这类题了，
 * E3:
 * > grid[i][j] = 1 not = '1' 看清输入数据的类型
 * > boolean[][] visited need to be initialized for bfs every time, from house,
 *   they're unique calculation and shouldn't be shared
 * > forget queue.add(new int[]{xNew, yNew});
 * > return 什么要搞清楚
 *   return res== Integer.MAX_VALUE ? -1:res;
 *
 * T:O(m^2n^2) ->O(number of 1)O(number of 0) ~ O(m^2n^2)
 * S:O(MN) - queue.depth
 *
 * 1/17/21
 *
 * 1/13/21
 *
 * 怎么想出来的：
 * > 构造变量，帮助记录附加值
 * reach[][] 在(xNew,yNew) 被loop过，且visited 保证所有的0在以特定房子为起始的条件下，都有机会被得到
 * dp[][] level是帮助他记录到底是多少层的工具
 *
 * > 1,2,3 as obstacle don't matter, let only pay attention to 0
 *
 * > why start from building '1'?
 * starting from buildings O(B*M*N) (B: # of buildings)
 *
 * starting from empty places O(E*M*N) (E: # of empty places)
 *
 * If the empty places are far more than buildings, ex. we have 1 million empty places and only 1 building,
 * starting from building is better.
 * So it depends on how many empty places and buildings that we have.
 * As a trade-off
 *
 */
public class _317_shortest_distance_from_all_buildings {
    /**
     * Step 1: start from every point 1 (building point), doing BFS traversal to fill out (or accumulate) distance array
     * (MUST start over and doing every BFS traversal individually)
     *
     * Step 2: find minimum distance from dp array
     *
     * @param dp: store distance sum to all building for every point 0. Update values when we do BFS traversal
     * @param reach: store number of buildings that every point 0 can reach. Used for checking if current point is valid
     *             while we want to find final result
     * @param countBuilding: count total number of point 1
     * */
    final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int[][] reach = new int[n][m];
        int countBuilding = 0;
        Queue<int[]> queue = new LinkedList<>();

        // step 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    bfs(queue, grid, dp, reach, n, m);
                    countBuilding++;
                }
            }
        }

        // step 2
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
                if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void bfs(Queue<int[]> queue, int[][] grid, int[][] dp, int[][] reach, int n, int m) {
        int level = 1;
        // DO NOT USE hashset, since hashset cannot determine whether it contains an array (coordinate)
        boolean[][] visited = new boolean[n][m];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = queue.poll();
                int x = curPoint[0];
                int y = curPoint[1];
                for (int j = 0; j < 4; j++) {
                    int dx = x + dir[j][0];
                    int dy = y + dir[j][1];
                    if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 || grid[dx][dy] != 0 || visited[dx][dy]) {
                        continue;
                    }
                    queue.offer(new int[]{dx, dy});
                    visited[dx][dy] = true;
                    // dp意味着某个特定的房子到这个0点的距离
                    dp[dx][dy] += level;
                    reach[dx][dy]++;
                }
            }
            level++;
        }
    }
}
