package greedy.interval;

import java.util.Arrays;

/**
 * interval range merge
 * 用尾巴 去追上一个的值
 *
 * 10/2/20.
 *
 * 2：
 *
 * 甩掉的是后缀大的，可以为后边可能出现的值留出空间
 *
 * 1/10/20
 *
 */
public class _435_non_overlapping_intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int res=0;
        // 比的是什么很重要，决定了到时候你要drop的是谁

        Arrays.sort(intervals,(a, b) -> a[1]-b[1]);
        int[] pre = intervals[0];
        for(int i=1; i<intervals.length; i++){
            if(pre[1]>intervals[i][0]){
                res++;
            }else{
                pre = intervals[i];
            }
        }
        return res;
    }
}
