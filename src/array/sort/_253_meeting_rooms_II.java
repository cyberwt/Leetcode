package array.sort;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 分别存 start[arr] end[arr] sorted
 *
 * Whenever there is a start meeting, we need to add one room.
 * But before adding rooms, we check to see if any previous meeting ends, which is why we check start with the first end.
 * When the start is bigger than end, it means at this time one of the previous meeting ends, and it can take and reuse that room.
 * Then the next meeting need to compare with the second end because the first end's room is already taken.
 * One thing is also good to know: meetings start is always smaller than end.
 * Whenever we pass a end, one room is released.
 *
 *
 *
 * 4/24/21.
 */
public class _253_meeting_rooms_II {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return 0;
        }
        // another possible solution


        // 局部greedy, 怎样建构
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int index = 0;
        for(int i=0; i<len; i++){
            if(start[i] < end[index]){
                res++;
            }else{
                index++;
            }
        }
        return res;
    }
   // min heap ,return max as lowest!
    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        int max = 0;
        PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, (a, b) -> (a.end - b.end));
        for(int i = 0; i < intervals.length; i++){
            while(!queue.isEmpty() && intervals[i].start >= queue.peek().end)
                queue.poll();
            queue.offer(intervals[i]);
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
