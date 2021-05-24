package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * same as 992
 *
 *
 * 3/31/21.
 */
public class _1248_count_number_of_nice_subarrays {
    public int numberOfSubarrays(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (A[j] % 2 == 1) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (A[i] % 2== 1) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
