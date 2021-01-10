package backtracking.array;

/**
 *很重要的一点:
 * local primitive need to initial
 * class don't need to ! int curMax =0
 *
 * T:O(N) S:O(1)
 *
 *11/30/20.
 */
public class _485_max_consecutive_ones {
    public int findMaxConsecutiveOnes(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int curMax =0, max=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                curMax++;
                max = Math.max(curMax,max);
            }else{
                curMax=0;
            }
        }
        return max;
    }
}
