package array.merge;

import java.util.ArrayList;

/**
 * 2S  8/2:
 * 1. 其实不用一直设置一个tem 干扰自己
 *  顺其自然就行
 *
 * 2. 思路被merge intervals 给干扰了
 * 第二段的while
 *  因为前面已经帮你排除了不相交的情况：if(intervals[index][1]< newInterval[0])
 *  所以此时的判断条件改成， 后解newIntervals[1]要拖着最前解 intervals[index][0]  才会有相交
 *
 * 3.Corner Case
 * 不能直接反原值，其实新值要被贴上，在两个while之后 res.add(newInterval);
 *
 *
 *
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
