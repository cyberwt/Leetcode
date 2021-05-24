package heap;

import java.util.PriorityQueue;

/**
 * M1
 * PriorityQueue, 定义得很巧妙，因为是sorted， 所以只有当不符合条件的时候才poll出来
 * 1. 怎么想到这么定义排序，
 * 因为y2+x2 恒是当前值，不会变，变的是比较 y1-x1
 * 2. 这有在不符合条件的情况下才poll出来
 *
 * 5/23/21.
 */
public class _1499_max_value_of_equation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - b[0] - (a[1] - a[0])));
        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] head = pq.peek();
                result = Math.max(result, point[1] + head[1] + point[0] - head[0]);
            }
            pq.offer(point);
        }

        return result;
    }



}
