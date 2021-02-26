package array.merge_two_pointer_overlap.scheduling;

import java.util.Arrays;

/**
 * > 如何sort二维数组 Arrays.sort(arr, (a,b) -> a[0]-b[0]);
 *
 * > Corner Case:
 * arr == null
 * arr<=1
 * arr like previous meeting end time equals to current meeting end time
 *
 *
 * 9/7/20.
 */
public class _252_meeting_rooms {

    public boolean canAttendMeetings(int[][] intervals) {
        // 可以在时间上 卡住么
        if(intervals == null || intervals.length <= 1){
            return true;
        }
        if(intervals.length == 1) return true;
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        int[] pre = intervals[0];

        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            if(pre[1]>cur[0]){
                return false;
            }
            pre = cur;
        }
        return true;
    }

}
