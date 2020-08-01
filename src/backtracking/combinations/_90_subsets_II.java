package backtracking.combinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 去重->
 * a. Arrays.sort(nums)
 * b. if(i>start && nums[i-1] != nums[i]) continue
 *
 *
 * 7/14/20.
 */
public class _90_subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length==0 ){
            return res;
        }
        Arrays.sort(nums);
        dfs(res, nums, new LinkedList<Integer>(), 0);
        return res;
    }


    public void dfs(List<List<Integer>> res, int[] nums, LinkedList<Integer> list, int index){
        res.add(new LinkedList<>(list));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(res,nums,list,i+1);
            list.remove(list.size()-1);

        }

    }

    public static void main(String[] args){
        _90_subsets_II solution = new _90_subsets_II();

        int[] testCase = {1,2,3};
        List<List<Integer>> res = solution.subsetsWithDup( testCase);
        System.out.println(res);
    }

}
