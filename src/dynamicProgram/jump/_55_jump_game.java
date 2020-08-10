package dynamicProgram.jump;

/**
 *  2S 8/2:
 *  1. 那个局部的最优解 是各种选择留下来的，到a(k-1) 是最优，那到a(k)的就是最优
 *
 *
 *  有一个 距离度量值的判断
 *
 *  动规，分出局部最优解，然后是最优的么，
 *
 *  T:O(N) S:O(1)
 *
 *  45题变种
 *
 *  7/2/20.
 */
public class _55_jump_game {
    public boolean canJump(int[] nums) {
        int max = 0;
        int temMax = 0;
        for(int i=0; i<nums.length; i++){
            if(i<=temMax){
                temMax=Math.max(nums[i]+i, temMax);

            }
            max = Math.max(max, temMax);
        }
        if(max >=nums.length-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _55_jump_game solution = new _55_jump_game();
        int[] test = {1,3,4,5};
        System.out.println(solution.canJump(test));
    }
}
