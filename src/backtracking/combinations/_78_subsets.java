package backtracking.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 没有dfs 退出模式，直接return add new list
 *
 * 为什么是deep copy, 你的理解好像差那么点意思
 *
 *
 *
 * 6/14/20.
 */
public class _78_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        // why it's necessary to sort, as the problems aked
        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(List<List<Integer>> res,
                       int[] nums,
                       int startIndex,
                       ArrayList<Integer> list
    ){
        res.add(new ArrayList<>(list));
        for(int i=startIndex; i<nums.length; i++){
            list.add(nums[i]);
            helper(res,nums,i+1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        _78_subsets solution = new _78_subsets();

        int[] testCase = {1,2,3};
        List<List<Integer>> res = solution.subsets( testCase);
        System.out.println(res);
    }
}
