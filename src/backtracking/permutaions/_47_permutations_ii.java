package backtracking.permutaions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在理解一遍
 *
 * if(bol[i] == true || i!=0 && nums[i-1]==nums[i]&& !bol[i-1])
 *
 * 4/1
 *
 *
 * > 和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素还未访问，那么就跳过这个元素。
 *
 * > 发现没懂这个表达式？
 * why,looks like this format
 *
 * 1/23/21
 * 借用boolean[] 去判断
 * 是否当前值已经被访问过，且 前一值没被访问过 like [1a,1b,1c,1d] 1a被访问过，其他值1b,,1c,1d就不应该被再拿到头上
 * With inputs as [1a, 1b, 2a],
 If we don't handle the duplicates, the results would be: [1a, 1b, 2a], [1b, 1a, 2a]...,
 so we must make sure 1a goes before 1b to avoid duplicates
 By using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a

 顺序已定，就不要打乱  1a，1b的位置

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
