package dynamicProgram;

/**
 * 8/1
 * M1 动规： 其实没完全理解
 * / 初值 必须要赋的
 *
 * / 动规  才是正常应该想出来的解，
 * dp[i] 和dp[i-1] 的关系，要不要负值
 * if (dp[i - 1] < 0) {
       dp[i] = nums[i];
   } else {
      dp[i] = dp[i - 1] + nums[i];
   }

   / res在每次loop的时候才能选出来
 *
 * M2: 进化成 只用两值的swap 结果
 *
 *
 * M1: 动规的极简
 *
 * 一维：
 * 用一个一维数组 dp [ i ] 表示以下标 i 结尾的子数组的元素的最大的和，也就是这个子数组最后一个元素是下边为 i 的元素，
 * 并且这个子数组是所有以 i 结尾的子数组中，和最大的
 * 如果 dp [ i - 1 ] < 0，那么 dp [ i ] = nums [ i ]。
 * 如果 dp [ i - 1 ] >= 0，那么 dp [ i ] = dp [ i - 1 ] + nums [ i ]
 *
 * T:O(N) S:O(1)
 * M2： 典型的递归+divide conquer
 *
 *
 *
 * 6/29/20.
 */
public class _53_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            //两种情况更新 dp[i]
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            //更新 max
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        return getSubMax(0, nums.length - 1, nums);
    }

    private int getSubMax(int start, int end, int[] nums) {
        //递归出口
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        //要找的数组不包含 mid，然后得到左边和右边最大的值
        int leftMax = getSubMax(start, mid, nums);
        int rightMax = getSubMax(mid + 1, end, nums);
        //要找的数组包含 mid
        int containsMidMax = getContainMidMax(start, end, mid, nums);
        //返回它们 3 个中最大的
        return Math.max(containsMidMax, Math.max(leftMax, rightMax));
    }

    private int getContainMidMax(int start, int end, int mid, int[] nums) {
        int containsMidLeftMax = 0; //初始化为 0 ，防止最大的值也小于 0
        //找左边最大
        if (mid > 0) {
            int sum = 0;
            for (int i = mid - 1; i >= 0; i--) {
                sum += nums[i];
                if (sum > containsMidLeftMax) {
                    containsMidLeftMax = sum;
                }
            }

        }
        int containsMidRightMax = 0;
        //找右边最大
        if (mid < end) {
            int sum = 0;
            for (int i = mid + 1; i <= end; i++) {
                sum += nums[i];
                if (sum > containsMidRightMax) {
                    containsMidRightMax = sum;
                }
            }
        }
        return containsMidLeftMax + nums[mid] + containsMidRightMax;
    }

    public static void main(String[] args){
        _53_maximum_subarray solution = new _53_maximum_subarray();
        int[] num1 = {3,7,7,-7,9,10};
        int test = solution.maxSubArray(num1);
        System.out.println(test);
    }

}
