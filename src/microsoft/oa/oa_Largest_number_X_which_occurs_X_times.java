package microsoft.oa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_Largest_number_X_which_occurs_X_times {
    public static int getLargestNum(int[] array) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : array) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int key = Integer.MIN_VALUE;
        int res = 0;
        for (Map.Entry<Integer, Integer> entity : hm.entrySet()) {
            if (entity.getKey() == entity.getValue()) {
                if (key < entity.getKey()) {
                    key = entity.getKey();
                    res = entity.getValue();
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 3, 3, 2};

        int res = getLargestNum(array);
        System.out.println(res);
    }
}
