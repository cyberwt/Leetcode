package backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 限制,加入list的个数: i<=n-k+1


 for (int i = start; i <= n - k + 1; i++)
    list.add
    dfs(res,list,i+1,k-1,n)
    list.remove

 理解，这种剪枝，发生的情况


 1/23/21


 为什么还是不能bug free做出来
 肯定是不断往下放，在不考虑移出
 Error at
 1. res.add(new LinkedList<Integer>(list)); why we must initial
 2. has a start index to help trace, also 往里放的时候，用的是i计数


 */
public class _77_combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(combineList, combinations, 1, k, n);
        return combinations;
    }

    private void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, final int n) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {  // 剪枝
            combineList.add(i);
            backtracking(combineList, combinations, i + 1, k - 1, n);
            combineList.remove(combineList.size() - 1);
        }
    }
}
