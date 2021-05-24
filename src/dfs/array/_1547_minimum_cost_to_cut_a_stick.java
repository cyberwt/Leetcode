package dfs.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * 先sort 一遍，这样，在下面，我直接可以去重，并且，重复使用
 *  if (cuts[i] <= l || cuts[i] >= r) continue;
 *
 *
 *
 * Created by weitong on 4/10/21.
 */
public class _1547_minimum_cost_to_cut_a_stick {
    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);
        return helper(cuts, new HashMap<>(), 0, n);
    }

    private int helper(int[] cuts, Map<String, Integer> memo, int l, int r) {

        int res = Integer.MAX_VALUE;

        String key = l + "-" + r;
        if (memo.containsKey(key)) return memo.get(key);

        for (int i = 0; i < cuts.length; ++i) {
            if (cuts[i] <= l || cuts[i] >= r) continue;

            int cost = r - l;
            res = Math.min(
                    // min cost of left stick + cost + min cost of right stick
                    helper(cuts, memo, l, cuts[i]) + cost + helper(cuts, memo, cuts[i], r),
                    res);
        }

        res = res == Integer.MAX_VALUE ? 0 : res;
        memo.put(key, res);

        return res;
    }
}
