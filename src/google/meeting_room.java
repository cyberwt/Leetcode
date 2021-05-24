package google;

import java.util.Arrays;

/**
 * Created by weitong on 4/22/21.
 */
public class meeting_room {
    //T:O(NlgN)
    public boolean isValid(int[][] programs, int[] input) {
        if(programs == null || programs.length == 0){
            return false;
        }
        Arrays.sort(programs, (a,b) -> (a[0] - b[0]));
        for(int[] program: programs){
            int curStart = program[0];
            int curEnd = program[0] + program[1];
            int inputStart = input[0];
            int inputEnd = input[0]+input[1];
            if(curStart >= inputEnd || inputStart >= curEnd){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isValid2(int[][] programs, int[] input){
        // already sorted
        if(programs == null || programs.length == 0){
            return false;
        }
        int left = 0, right = programs.length-1;
        while(left < right){
            int mid = (right -left)/2 + left;
            if(programs[mid][0] >= input[0]+input[1]){
                right = mid+1;
            }else if(programs[mid][1] <= input[0]){
                left = mid;
            }else{
                return false;
            }
        }
        if(programs[left][0] >= input[0]+input[1] || programs[left][1] <= input[0]){
            return true;
        }

        return false;
    }

}
