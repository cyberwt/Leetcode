package backtracking.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Trick：
 * 1.一个元素用一次，如何去重: 不再当作要加的头了
 * if(i>index && nums[i-1] == nums[i]) continue
 * 2.必须 arrays.sort(nums)
 *
 * T:O(2^N) S:O(N)
 *
 * 6/15/20.
 */
public class _40_combination_sum_ii {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }

        // do I need to sort, yes! will drop the duplicate heading
        Arrays.sort(candidates);

        dfs(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] candidates, int remain, ArrayList<Integer> list, int index){
        if(remain <= 0){
            if(remain == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(res, candidates, remain-candidates[i],list,i+1);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args){
        _40_combination_sum_ii solution = new _40_combination_sum_ii();

        int[] testCase = {1,2,3};
        List<List<Integer>> res = solution.combinationSum2( testCase,4);
        System.out.println(res);
    }

}
