package array.merge_two_pointer_overlap.scheduling;

import java.util.TreeMap;

/**
 *
 * loop through the hashmap,
 *
 * use inorder count to record if there is time inside it to let k>2
 * ex: (1,4) (2,5) (3,5) how many in it, and how many are out,
 *
 * if(k_max >2){
 *     return false
 * }
 *
 *
 *
 * T:O(N) S:O(N)
 * 3/14/21.
 */
public class _731_my_calendar_II {
    private TreeMap<Integer, Integer> map;
    public _731_my_calendar_II() {
        map = new TreeMap<>();
    }

    public boolean book(int s, int e) {
        map.put(s, map.getOrDefault(s, 0) + 1);
        map.put(e, map.getOrDefault(e, 0) - 1);

        int cnt = 0, k = 0;
        for (int v : map.values()) {
            k = Math.max(k, cnt += v);
            if (k > 2) {
                map.put(s, map.get(s) - 1);
                map.put(e, map.get(e) + 1);
                return false;
            }
        }
        return true;
    }
}
