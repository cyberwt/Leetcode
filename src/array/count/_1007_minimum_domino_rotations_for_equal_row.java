package array.count;

/**
 * 根据两个序列互补的特性，A[count] + B[count] - same[count] = len
 *
 *
 * 4/23/21.
 */
public class _1007_minimum_domino_rotations_for_equal_row {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || B== null || A.length != B.length){
            return -1;
        }
        int len = A.length;
        int[] Acount = new int[7];
        int[] Bcount = new int[7];
        int[] same = new int[7];
        for(int i=0 ;i<A.length;i++){
            Acount[A[i]]++;
            Bcount[B[i]]++;
            if(A[i] == B[i]){
                same[A[i]]++;
            }
        }
        int res  = Integer.MAX_VALUE;
        for(int i=1; i<=6 ; i++){
            if(Acount[i]+Bcount[i] - same[i] == len){
                res = Math.min(res, Math.min(Acount[i], Bcount[i])-same[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1:res;
    }
}
