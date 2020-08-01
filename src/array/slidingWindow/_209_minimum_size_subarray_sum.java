package array.slidingWindow;

/**
 * Created by weitong on 7/10/20.
 */
public class _209_minimum_size_subarray_sum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0] >= s ? nums[0]:0;
        }

        int res = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        for(int i=0; i<nums.length;i++){
            count += nums[i];
            while( count>= s){
                System.out.println(i + " " +left +  " " + count);
                res = Math.min(res,i-left+1);
                count -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0: res;
    }

    public static void main(String[] args){
        _209_minimum_size_subarray_sum solution = new _209_minimum_size_subarray_sum();
        int[] test_case = {1,1,1,1,2,2,2,3};
        int res = solution.minSubArrayLen( 3,test_case);
        System.out.println(res);
    }

}
