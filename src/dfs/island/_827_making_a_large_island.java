package dfs.island;

/**
 *
 * 1.如果一个零值都不存在，那这个图是一个满树
 *
 * 2.TLE 但可以好好理解，每次反转摸一个0值，
 *
 * 3. 返回是要+1的， 因为是此图有意义
 * 4/3/21.
 */
public class _827_making_a_large_island {
    public int largestIsland(int[][] a) {
        int max = -1, n = a.length, m = a[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] == 0) {
                    a[i][j] = 1;
                    max = Math.max(max, dfs(i, j, a, new boolean[n][m]));
                    a[i][j] = 0;
                }
        return max == -1 ? a.length * a[0].length : max;
    }

    int dfs(int i, int j, int[][] a, boolean[][] seen) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] != 1 || seen[i][j]) return 0;
        seen[i][j] = true;
        return dfs(i + 1, j, a, seen) + dfs(i - 1, j, a, seen) + dfs(i, j + 1, a, seen) + dfs(i, j - 1, a, seen) + 1;
    }
}
