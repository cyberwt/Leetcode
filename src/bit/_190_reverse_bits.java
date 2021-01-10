package bit;

/**
 * 先动result, 然后移n,
 * 结果加进去
 *
 * 8/20/20.
 */
public class _190_reverse_bits {
    public int reverseBits(int n) {
        if(n == 0){
            return 0;
        }
        int result =0;
        for(int i=0; i<32; i++){
            result <<= 1;
            if((n&1) == 1) result ++;
            n>>= 1;
        }

        return result;
    }
}
