package array.merge_two_pointer_overlap.scheduling;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * 为什么黑盒在这里work
 *
 *
 *
 *
 * 3/27/21 这种散开放进数组，让我不知道，要怎么解释
 *
 * M1: 等价为:
 *
 * 最关键的是要证明“求最少房间数”这一原问题与“寻找最大重叠区间”这一对偶问题的等价性
 *
 * 底下的for-loop可以想像成，把所有的start跟end依照时间排序, 每遇到start就得多开一个房间(stack++),
 * 每遇到end就可以把一个房间给关了(stack--)
 * 如此一来, 在for-loop遍历所有的event之下, res可以记录下所需最多房间的数量。
 *
 * M2: priority queue
 * change room meeting time end_time, if there's no need to start a new room
 *
 *
 * M3:
 * Sort all time point
 *
 * Track the change of room numbers in time order.
 * Explanation:
       Save all time points and the change on current meeting rooms.
       Sort all the changes on the key of time points.
       Track the current number of using rooms cur and update result res.
 *
 *
 *
 *
 *
 * 2/14/21
 *
 * > 打乱了所有start end 的排列，然后看start end 到底能不能 match 到一个新房间里
 *
 * 9/7/20.
 */
public class _253_meeting_rooms_II {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null ){
            return 0;
        }

        if(intervals.length <= 1){
            return intervals.length;
        }
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];

        for(int i=0 ;i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0, index =0,stack=0;
        for(int i=0; i<len; i++){
            if(start[i]<end[index]){

                stack++;
                res = Math.max(stack, res);

            }else{
                index++;
                stack--;
            }
        }
        return res;
    }


    public int minMeetingRooms2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) { return 0; }
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((interval1, interval2) -> interval1[1] - interval2[1]);
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = heap.poll(); // first end meeting
            if (intervals[i][0] >= pre[1]) { // no more room needs as no conflict
                pre[1] = intervals[i][1]; // extend end-time for frist meeting room
            } else { // another meeting room as conflict
                heap.offer(intervals[i]);
            }
            heap.offer(pre);
        }
        return heap.size();
    }

    public int minMeetingRooms3(int[][] intervals) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : intervals) {
            m.put(t[0], m.getOrDefault(t[0], 0) + 1);
            m.put(t[1], m.getOrDefault(t[1], 0) - 1);
        }
        int res = 0, cur = 0;
        for (int v : m.values()) {
            res = Math.max(res, cur += v);
        }
        return res;
    }
}
