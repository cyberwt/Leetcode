package dfs.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * same as maze keep rolling
 *
 * Diff:
 * Construct {x,y, dis} to get the minimal distance
 *
 * T:O(M*N) S:O(M*N)
 *
 * 1/18/21.
 */
public class _505_the_maze_II {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int res = Integer.MAX_VALUE;
        int m = maze.length;
        int n = maze[0].length;

        int[][] move = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] length = new int[m][n];
        for (int i = 0; i < m * n; i++)
            length[i / n][i % n] = Integer.MAX_VALUE;
        // Initial distance here.
        queue.offer(new int[] {start[0], start[1], 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (length[cur[0]][cur[1]] <= cur[2])
                continue;
            length[cur[0]][cur[1]] = cur[2];
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                res = Math.min(cur[2], res);
            }

            for (int[] mo : move) {
                int x = cur[0], y = cur[1];
                int d = cur[2];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += mo[0];
                    y += mo[1];
                    d++;
                }
                d--;
                // Back to validate point.
                x -= mo[0];
                y -= mo[1];

                // Adding new start point. d is distance.
                queue.offer(new int[] {x, y, d});
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}


