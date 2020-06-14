package greedy.array;

/**
 * 每一步我都要跳得最远
 *
 * 在能跳到最远的每个可能性中，再更新最远的值
 *
 * 有一个 Error 点
 * 因为一开始的那步,step被迫加 1：
 * i = 0 step++
 *
 * 6/14/20.
 */
public class _45_jump_game_ii {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int end = 0;
        int step = 0;
        int maxPos = 0;

        for(int i=0; i<nums.length-1; i++){
            maxPos = Math.max(maxPos, nums[i]+i);
            if(i == end){
                end = maxPos;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        _45_jump_game_ii solution = new _45_jump_game_ii();
        int[] test = {2,1,3,4,5,10} ;
        int res = solution.jump(test);
        System.out.println(res);
    }
}
