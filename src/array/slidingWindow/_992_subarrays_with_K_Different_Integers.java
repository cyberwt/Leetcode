package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1. Exact(k) = atMost(K) - atMost(K-1)
 * 2. get results by
 * res += j-i+1
 *
 *
 * 3/31/21.
 */
public class _992_subarrays_with_K_Different_Integers {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
