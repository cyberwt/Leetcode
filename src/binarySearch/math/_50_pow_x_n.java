package binarySearch.math;

/**
 * Binary Search
 *
 * CC:
 * 1. n的 integer.MIN_VALUE 不变质 -> 先转换成 long 型
 *
 * Understanding:
 * 余数为一是要保留，而且要一直二倍二倍的进行
 *
 *
 * T:O(logN) S:O(1)
 *
 * 6/14/20.
 */
public class _50_pow_x_n {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                System.out.println(i);
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    public static void main(String[] args) {
        _50_pow_x_n solution = new _50_pow_x_n();

        double res = solution.myPow(2.0,10);
        System.out.println(res);
    }
}
