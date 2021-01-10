package Hash.hashtable.line;

import java.util.HashMap;
import java.util.Map;

/**
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
}
