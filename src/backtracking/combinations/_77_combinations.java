package backtracking.combinations;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *

 为什么还是不能bug free做出来
 肯定是不断往下放，在不考虑移出
 Error at
 1. res.add(new LinkedList<Integer>(list)); why we must initial
 2. has a start index to help trace, also 往里放的时候，用的是i计数



 */
public class _77_combinations {
    public List<List<Integer>> combine(int n, int k) {
        //backtrack

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<Integer>();
        helper(list,res,n,k,1);
        return res;
    }

    public void helper(List<Integer> list,List<List<Integer>> res, int n, int k, int start){
        if(list.size()==k){
            res.add(new LinkedList<Integer>(list));
            return;
        }

        for(int i=start; i<=n - (k-list.size()) +1; i++){
            // how can I avoid to add values to the list
            list.add(i);
            helper(list, res, n,k,i+1);
            list.remove(list.size()-1);
        }

    }
}
