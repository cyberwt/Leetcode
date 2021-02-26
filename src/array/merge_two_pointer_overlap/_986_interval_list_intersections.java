package array.merge_two_pointer_overlap;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路是没错的，比 startMax, endMax,
 *
 * 但细节写不出来: startMax, endMin meaningful way
 * > 变量命名
 * > list -> arr build-in function
 *     . new int[][]{}
 *     . res.add(new int[]{startMax, endMin})
 *     . res.toArray(new int[res.size()][2])
 *
 * > 思考过程：
 * .摆两个time slot to see which fits in diff position
 *
 * T:O(Math.min)
 *56
 *
 * ?? how to tackle with the follow up:
 * https://www.1point3acres.com/bbs/thread-715067-1-1.html
 *
 * 2/11/21.
 */
public class _986_interval_list_intersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return new int[][]{};
        List<int[]> res = new ArrayList<>();

        int i = 0, j = 0;
        int startMax, endMin;
        while(i < A.length && j < B.length){
            startMax = Math.max(A[i][0], B[j][0]);
            endMin = Math.min(A[i][1], B[j][1]);

            if(endMin >= startMax)
                res.add(new int[]{startMax, endMin});

            if(A[i][1] == endMin) i++;
            if(B[j][1] == endMin) j++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
