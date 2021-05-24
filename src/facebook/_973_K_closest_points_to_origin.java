package facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * 理解最大堆哎 -> 升序  PriorityQueue<int[]>((a,b)->(b[0]*b[0]+b[1]*b[1] -a[0]*a[0]-a[1]*a[1]));
 *
 *
 *
 *
 *  4/4/21
 *
 * -- Pq: E1:
 *
 * 1. 怎么写
 * new PriorityQueue<int[]>((a,b)->(b[0]*b[0]+b[1]*b[1] -a[0]*a[0]-a[1]*a[1]));
 * 2. 返回值 pq.toArray(new int[k][2]);
 *
 *
 *
 *
 *  Kth 比较
 *  各个方法优劣，复杂度
 *
 *  2/21/21.
 */
public class _973_K_closest_points_to_origin {

    /**
     * M1:
     * 正常: Arrays.sort(), 带出 points的距离
     *  > offline method, need to know previous points
     *  > easy to implement
     *
     * T:O(NlogN), S:O(1)
     *
     *
     * M2:
     * priorityQueue, offer K size
     *
     *  > online method
     *  > not efficient as expected
     *
     * T:O(NlogK) !, S:O(1)
     */

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest2(int[][] points, int K) {
        // priority queue
        // head

        // how to write its comparator
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> (b[0]*b[0] + b[1]*b[1] -a[0]*a[0] - a[1]*a[1]));
        for(int[] point: points){
            queue.offer(point);
            if(queue.size() > K){
                queue.poll();
            }
        }

        int[][] res = queue.toArray(new int[K][2]);
        return res;
    }

    /**
     * M3:
     * Quick select,
     *
     * 把大于的值放到左右两面
     *
     *
     * T:O(N) S:O(1)
     *
     */
    public int[][] kClosest3(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

}
