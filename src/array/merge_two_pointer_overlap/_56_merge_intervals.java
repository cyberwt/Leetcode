package array.merge_two_pointer_overlap;

import array.math._43_multiply_strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 *
 * 2s:
 * 1. 二维数组理解的不好 int[] tem = intervals[0];
 *
 * 型为 int[n][2] 的一个数组
 *
 * 2. comparator 怎么写
 *
 * Arrays.sort(intervals, (a1,a2)-> a1[0] - a2[0]);
 *
 * 3. 什么意思
 * res.toArray(new int[0][]);
 *
 *
 *
 * 思考时间多了，但思路更清晰了
 *
 * Error:
 * 1. 最后需不需要重验，加上最后一个结果
 *
 * 2. merge 的时候，因为sort 过，只需要考虑边界条件，是否已被 merge ,要开新串
 *
 *
 * 两个Java知识点：
 *
 * Arrays.sort(intervals, (a1,a2)-> a1-a2)
 *
 * res.toArray(new int[res.size()][])
 *
 *
 * 7/3/20.
 */
public class _56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        // CC
        if(intervals == null || intervals.length <= 0){
            return intervals;
        }

        ArrayList<int[]> res = new ArrayList<int[]>();
        // can't remember the fancy expression
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        int[] tem = intervals[0];

        for(int i=1; i<intervals.length; i++){
            if(tem[1]>= intervals[i][0]){
                tem[1] = Math.max(tem[1], intervals[i][1]);
            }else{
                res.add(tem);
                tem = intervals[i];
            }
        }
        // ! always to remember last value!!!
        res.add(tem);

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args){
        _43_multiply_strings solution = new _43_multiply_strings();

        String res = solution.multiply( "123", "456");
        System.out.println(res);
    }
}
