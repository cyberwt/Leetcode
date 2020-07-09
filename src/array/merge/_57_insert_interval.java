package array.merge;

import java.util.ArrayList;

/**
 *
 * 3个 while loop 找不合规范的数组
 *
 * T:O(N) S:O(1)
 *
 * 7/4/20.
 */
public class _57_insert_interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // merge arrays
        ArrayList<int[]> res = new ArrayList<>();
        int index = 0;
        int len = intervals.length;

        while(index<len && intervals[index][1]< newInterval[0]){
            res.add(intervals[index]);
            index++;
        }

        while(index<len && intervals[index][0]<= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[index][1]);
            index++;
        }
        res.add(newInterval);
        while(index < len){
            res.add(intervals[index++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
