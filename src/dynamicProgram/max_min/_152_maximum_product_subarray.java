package dynamicProgram.max_min;

/**
 *  放在dp的框架里去理解
 *  子问题： 到i为止，能取的到的最大乘积
 *  最后一步：在当前位置是的最大值
 *
 *  转移方程： 特殊情况，先判断是正是负，然后决定了政府之后，看是否要携带此值
 *
 *  但负值，要取的是 Math.min
 *
 *
 *
 * 8/11/20.
 */
public class _152_maximum_product_subarray {
    public int maxProduct(int[] nums) {
        // cc
        if(nums == null || nums.length ==0){
            return 0;
        }
        int posVal = nums[0],
                negVal = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){

            if(nums[i] <0){
                int tem = posVal;
                posVal = negVal;
                negVal = tem;
            }
            posVal = Math.max(nums[i], posVal*nums[i]);
            negVal = Math.min(nums[i], negVal*nums[i]);
            max = Math.max(max, posVal);

        }
        return max;
    }
}
