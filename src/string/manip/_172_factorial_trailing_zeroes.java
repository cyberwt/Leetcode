package string.manip;

/**
 * 根据题意总结归纳的
 *
 * General Method:
 * > 什么组成，有什么情况 是condition 满足的田间
 * > 一层：通俗的 >> 可以再被精简么
 * > 概括总结后的最简条件
 *
 * S M:
 * 是 2x5 构成后面的trailing zero
 * 2出现的频率更高，找5
 * 5一次，25两次，125三次
 * 一直除尽
 *
 * 8/16/20.
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
