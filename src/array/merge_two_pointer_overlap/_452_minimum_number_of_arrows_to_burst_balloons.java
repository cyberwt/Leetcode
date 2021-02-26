package array.merge_two_pointer_overlap;

import java.util.Arrays;

/**
 * E:
 * 1. res start from 1
 * 2. 缩小置信区间
 *
 * 10/2/20.  2/12/21
 *
 * 2:
 *
 * > res 是从1开始的 or 结尾res+1
 *
 * > 算的是 每个置信区间 的有效性， 渐渐缩小置信区间，不是meger 使其变大
 * pre[0] = Math.max(pre[0],cur[0]);
   pre[1] = Math.min(pre[1],cur[1]);

   > sort 的两种方法
   Arrays.sort(points,(a, b)->a[0]-b[0]);
   Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

 */
public class _452_minimum_number_of_arrows_to_burst_balloons {
    public int findMinArrowShots(int[][] points) {
        //排除这种真正交集，也是有迹可循
        if(points == null || points.length == 0){
            return 0;
        }
        int res =1;
        Arrays.sort(points,(a, b)->a[0]-b[0]);
        //Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int[] pre = points[0];
        for(int i=1;i<points.length;i++){
            int[] cur = points[i];
            if(pre[0] <= cur[0] && pre[1] >= cur[0]){
                pre[0] = Math.max(pre[0],cur[0]);
                pre[1] = Math.min(pre[1],cur[1]);
                // System.out.println("pre[0]: " + pre[0] + "pre[1]: " + pre[1]);
            }else{
                res++;
                pre = cur;

            }
        }
        return res;
    }
    // error 1: 落加了一个res res=1 开始
}
