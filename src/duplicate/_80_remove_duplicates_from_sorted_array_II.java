package duplicate;

/**
 *
 * 他每个count是1开始， 若count 不是1了，就替换掉
 * 然后  slow 被替换的是此刻的 fast
 *
 *
 *
 * 7/11/20.
 */
public class _80_remove_duplicates_from_sorted_array_II {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int slow = 0;
        int fast =1;
        int count = 1;
        for(int i=fast; i<nums.length; i++){
            if(nums[slow] == nums[i]){

                if(count<2){
                    slow++;
                    nums[slow] = nums[i];
                    count++;
                }
            }else{
                count = 1;
                slow++;
                nums[slow] = nums[i];

            }
        }
        return slow+1;
    }

}
