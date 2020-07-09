package dynamicProgram.jump;

/**
 * M1:
 * DP 初值边界，转移方程，跳出条件
 * T:O(N) S:O(1)
 *
 *
 * M2:
 * 递归：再往下跳的是活，先判断此值存不存在
 *
 *
 * 7/5/20.
 */
public class _70_climbing_stairs {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climbStairsN(n, memo);
    }
    private int climbStairsN(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = 0;
        //数组的默认值是 0
        if (memo[n - 1] == 0) {
            n1 = climbStairsN(n - 1, memo);
            memo[n - 1] = n1;
        } else {
            n1 = memo[n - 1];
        }
        int n2 = 0;
        if (memo[n - 2] == 0) {
            n2 = climbStairsN(n - 2, memo);
            memo[n - 2] = n2;

        } else {
            n2 = memo[n - 2];
        }
        return n1 + n2;
    }

    public static void main(String[] args) {
        _70_climbing_stairs solution = new _70_climbing_stairs();

        System.out.println(solution.climbStairs(4));
    }
}
