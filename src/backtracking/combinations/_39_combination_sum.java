package backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs(res, int[] candidates, int remain, ArrayList<Integer> list, int startIndex)
 *
 * 为了让 candidates[i] 可以被重复用，设置了startIndex, 且每次 dfs(res, candidates, remain-candidates[i],list,i);
 * i无需自动进位
 *
 * T:O(2^N) S:O(N)
 *
 *
 * 6/15/20.
 */
public class _39_combination_sum {public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if(candidates == null || candidates.length == 0){
        return res;
    }

    // do I need to sort, no, it'll verify every results FROM every index
    // but results will look pretty and it's faster to drop bas results
    //Arrays.sort(candidates);

    // is the List need to be ini as desired? yes!
    //error: List is abstract; cannot be instantiated
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
            list.add(candidates[i]);
            dfs(res, candidates, remain-candidates[i],list,i);
            list.remove(list.size()-1);
        }

    }


    public static void main(String[] args){
        _39_combination_sum solution = new _39_combination_sum();

        int[] testCase = {1,2,3};
        List<List<Integer>> res = solution.combinationSum( testCase,4);
        System.out.println(res);
    }

}
