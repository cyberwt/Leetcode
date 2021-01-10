package array.math;

/**
 *
 * 要写，就好好写，别叫一个50分的东西出来，代表你自己
 *
 * 8/15/20.
 */
public class _167_two_sum_II_input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length ==0){
            return res;
        }
        int low =0, high=numbers.length-1;
        while(low < high){
            int val = numbers[low] + numbers[high];
            if(val == target){
                res[0] = low+1;
                res[1] = high+1;
                return res;
            }
            if(val > target){
                high--;
            }
            if(val < target){
                low++;
            }
        }
        return res;
    }
}
