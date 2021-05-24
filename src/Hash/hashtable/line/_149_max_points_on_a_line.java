package Hash.hashtable.line;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * M2,
 * E:
 * 1. 用一个 hashset 记录已visited 的node
 * 2. node是有duplicate的 ！
 * 3. getSlope 有三种情况，不重不漏
 *
 * >M1 gcd
 * 不用double 了，直接int 可以求出 dy/gcd, dx/gcd => 表示slope
 *
 * T:O(N^2) S:O(N) as the worst, all in the set/all in different line
 *
 * 5/16/21
 *
 *
 *
 *
 * gcd是干嘛的
 *
 * 以最外层循环为 判断原点，一直向下一个值走，就不会判断重:
 *
 * a. 有重复点 duplicate++
 * b. 新点，
 *   借用 gcd(Greatest Common Divisor)  dX = deltaX/gcd  dY = deltaY/gcd
 *   dX + " " + dY = key
 *
 *   两个，一个局部变量max  (不一定是那两条线段，组成了以此端点为头的最大值)
 *   一个全局res (一开始由两点构成 一条线，少加了一个1)
 *
 *
 *
 * 8/10/20.
 */
public class _149_max_points_on_a_line {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;

        int solution = 0;

        for (int i = 0; i < points.length; i++)
        {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++)
            {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                if (deltaX == 0 && deltaY == 0)
                {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(deltaX, deltaY);
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;

                map.put(dX + "," + dY, map.getOrDefault(dX + "," + dY, 0) + 1);
                max = Math.max(max, map.get(dX + "," + dY));
            }

            solution = Math.max(solution, max + duplicate + 1);
        }

        return solution;
    }


    public int gcd(int a, int b){
        while(b != 0){
            int tem = a%b;
            a =b;
            b=tem;
        }
        return a;
    }

    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (n < 2) return n;
        Set<String> set = new HashSet<>();
        int max = 1;

        for (int i = 0; i < n && !set.contains(points[i][0]
                + "-" + points[i][1]); i++) {
            int[] a = points[i];
            int same = 0;
            Map<Double, Integer> map = new HashMap<>();
            int localMax = 1;

            for (int j = i + 1; j < n; j++) {
                if (isSame(a, points[j])) {
                    same++;
                    continue;
                }

                double slope = getSlope(a, points[j]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }

            set.add(a[0] + "-" + a[1]);
            max = Math.max(max, localMax + same);
        }

        return max;
    }

    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private double getSlope(int[] a, int[] b) {
        if (a[0] == b[0]) return Double.MAX_VALUE;
        if (a[1] == b[1]) return 0;
        return ((double) b[0] - a[0]) / ((double) b[1] - a[1]);
    }
}
