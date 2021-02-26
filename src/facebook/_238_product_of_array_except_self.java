package facebook;

/**
 *
 * >> 怎么构建出理想的答案
 *
 * loop the array get left part of the array, the get the right part
 *
 * both loop will skip of current value
 *
 * Corner case here: 0 ruin the results, makes rest = 0, not acceptable and should be skip
 *
 *
 *  T:O(N) S:O(N)
 * 2/21/21.
 */
public class _238_product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        // input negtative or positive
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i=1; i< nums.length; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int right = 1;

        for(int j=nums.length-1; j>=0; j--){
            res[j] = res[j] * right;
            right = right* nums[j];
        }

        return res;
    }
}
