package math.system;

/**
 *
 * 尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。

   对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，
   其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，
   N/5^2 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。

 如果统计的是 N! 的二进制表示中最低位 1 的位置，只要统计有多少个 2 即可
 *
 * 1/30/21.
 */
public class _172_factorial_trailing_zeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
