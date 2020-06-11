package backtracking.permutations;

import java.util.LinkedList;
import java.util.List;

/**
 * backtracking
 *
 * 需要理解code到底怎么运行的，Run & check printout
 *
 * 两个难懂的初始化格式：
 * why can not initialize: ?
 * - List<List<Integer>> res = new LinkedList<LinkedList<Integer>>() works or not
 * why res.add(new LinkedList<>(list)) will work
 *
 *
 *  T:O(N^n) S:O(1)
 * 6/9/20.
 */
public class _46_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<Integer>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new LinkedList<>(list));
        }else{
            for(int i=0; i<nums.length; i++){
                if(list.contains(nums[i])) continue;
                System.out.println("i = "+ i + ",list = "+ list+ ",res = "+res);
                list.add(nums[i]);
                backtrack(res,list,nums);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args){
        _46_permutations solution = new _46_permutations();

        int[] testCase = {1,2,3};
        List<List<Integer>> res = solution.permute( testCase);
        System.out.println(res);
    }
}
