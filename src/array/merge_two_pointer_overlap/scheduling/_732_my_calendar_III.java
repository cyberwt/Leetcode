package array.merge_two_pointer_overlap.scheduling;

import java.util.TreeMap;

/**
 * E1:
 *
 * 记录局部最大值  with in/out degree
 *  看black box此次是有几个overlap
 *
 * T:O(N)
 * 3/14/21.
 */
public class _732_my_calendar_III {
    TreeMap<Integer, Integer> map;
    int res;
    public _732_my_calendar_III() {
        map = new TreeMap<Integer, Integer>();
        res = 0;
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start,0) + 1);
        map.put(end, map.getOrDefault(end,0)-1);
        int cnt = 0, k = 0;
        // E1: 还是需要记录局部最大值
        for(int val: map.values()){
            k = Math.max(k, cnt += val);
        }
        return k;
    }

}
