package dynamicProgram.count;

/**
 *
   Error 1: 我只找了一次，但此题要求全部可能解
   Two pointers is little week here to get all
   and it will skip the value between slow and fast


   How to use dp instead?

   从一维 dp 开始理解

 * 9/15/20.
 */
public class _413_arithmetic_slices {
    // M1: brute force in for--loop
    // 中间有几次 i的其实位置没对好
    public int numberOfArithmeticSlices(int[] A) {
        int res =0;
        if(A == null || A.length <3){
            return res;
        }
        int len = A.length;
        for(int i=1; i<len-1; i++){
            int next = i+1;
            int diff = A[i] -A[i-1];
            while(next<len && A[next] - A[next-1] == diff){
                next++;
                res++;
            }

        }
        return res;
    }
}
