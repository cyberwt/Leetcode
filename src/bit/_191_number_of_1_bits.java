package bit;

/**
 * 是判断  n!=0, 而非 n>0 因为n会为负值
 *
 *
 * 8/20/20.
 */
public class _191_number_of_1_bits {
    public int hammingWeight(int n) {
        int res =0;
        while(n !=0){
            if((n&1) == 1) res++;
            n = n>>> 1;
        }
        return res;
    }
}
