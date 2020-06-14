package backtracking.permutaions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 借用boolean[] 去判断
 * 是否当前值已经被访问过，且 前一值没被访问过 like [1a,1b,1c,1d] 1a被访问过，其他值1b,,1c,1d就不应该被再拿到头上
 *
 *
 * 6/14/20.
 */
public class _47_permutations_ii {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] bol = new boolean[nums.length];
        helper(nums, new ArrayList<Integer>(), res,bol);
        return res;
    }

    public void helper(int[] nums, ArrayList<Integer> list, List<List<Integer>> res, boolean[] bol){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            // do I need to emphasize a return parse here?

            // this will = if() return no else
            //return;
        }else{

            for(int i=0; i<nums.length; i++){

                if(bol[i] == true || i!=0 && nums[i-1]==nums[i]&& !bol[i-1]) continue;
                bol[i] = true;
                list.add(nums[i]);
                helper(nums, list,res,bol);
                bol[i] = false;
                list.remove(list.size()-1);
            }
        }

    }
}