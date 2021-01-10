package array.merge;

import java.util.Arrays;

/**
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

        int res = 0, index =0;
        for(int i=0; i<len; i++){
            if(start[i]<end[index]){
                res++;
            }else{
                index++;
            }
        }
        return res;
    }
}
