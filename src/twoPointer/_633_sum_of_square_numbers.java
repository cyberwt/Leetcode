package twoPointer;

/**
 * Notes:
 *
 * 1. int j = (int) Math.sqrt(c); 原解是double型
 *
 * 2.while(i <= j) the range: [0, Integer.MAX_VALUE]
 *
 *
 * 1/27/21.
 */
public class _633_sum_of_square_numbers {
    public boolean judgeSquareSum(int c) {
        if(c<0){
            return false;
        }
        int i=0, j=(int)Math.sqrt(c);

        // a = b is possible
        while(i<=j){
            int tem = i*i + j*j;
            if(tem == c){
                return true;
            }else if(tem > c){
                j--;
            }else{
                i++;
            }
        }

        return false;
    }
}

