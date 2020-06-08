package binarySearch.math;

/**
 * 二分法 + 递归 直至退出循环
 *
 * Trick: 负值求余
 *
 * T: O(NlogN) S:O(1)
 *
 * CC 也是要处理，最小值不被转化为最大值 而溢出
 *
 * 为什么要反向用负值求余，因为只要被除数是 Integer.MIN_VALUE = Math.abs(Integer.MIN_VALUE)
 * 整个运算体系就不成立了，没有转换为正值系统
 *
 * 6/7/20 - need rewrite by yourself!
 */
public class _29_divide_two_integers {
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
            sum += sum;
            q += q;
        }
        return q + div(dividend - sum, divisor);
    }

    public static void main(String[] args){
        _29_divide_two_integers solution = new _29_divide_two_integers();

        int res = solution.divide( 1234,1234);
        System.out.println(res);
    }

}
