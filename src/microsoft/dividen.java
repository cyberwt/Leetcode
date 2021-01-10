package microsoft;

/**
 *  a.先判段第一个反值
 *  b.sign_flag
 *  c. helper(neg,neg)  why?
 *  不会将 dividend 转错，在min_value时
 *  d. while(dividend <= sum + sum && sum + sum < sum)
 *  保护了 min + min = 0
 *  且 Math.abs(min)= min
 *
 *  9/10/20.
 */
public class dividen {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean sign = (dividend < 0) == (divisor < 0);
        int res = div(-Math.abs(dividend), -Math.abs(divisor));
        return sign? res: -res;
    }

    public int div(int dividend, int divisor){
        if(dividend > divisor) return 0;
        int sum = divisor, q = 1;
        while(dividend <= sum + sum && sum + sum < sum){
            System.out.println(sum);
            sum += sum;
            q += q;
        }
        return q + div(dividend - sum, divisor);
    }
}
