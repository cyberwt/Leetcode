package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_fill_with_0 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int left = 0, right = n - 1, start = 1;
        while (left < right) {
            res[left++] = start;
            res[right--] = -start;
            start++;
        }
        return res;
    }
}
