package dynamicProgram.count;

/**
 * 初始值， 状态转移方程
 *
 * 1.边界值，让出了 0 & len-1 对应的左右边界么，所以是 [0, len+2]
 * 2. 理解 3个 循环， 定义了 left, right, k
 * 3.  maxCoin[left][right] = Math.max(maxCoin[left][right], maxCoin[i][k] + arrp*arr[k]);
 *
 *
 * https://leetcode-cn.com/problems/burst-balloons/solution/zhe-ge-cai-pu-zi-ji-zai-jia-ye-neng-zuo-guan-jian-/
 * 4/12/21.
 */
public class _312_burst_balloons {
    public int maxCoins(int[] nums) {
        // cc check
        if(nums == null || nums.length ==0){
            return 0;
        }
        int len = nums.length;
        int[] arr = new int[len+2];
        arr[0] = 1;
        for(int i=1;i<len+1;i++){
            arr[i]=nums[i-1];
        }
        arr[len+1] =1;
        int[][] maxCoin = new int[len+2][len+2];

        for(int dis=2; dis<len+2;dis++){
            for(int left=0; left+dic<len+2;left++){
                int right = left+dis;
                for(int i=left+1; i<right; i++){
                    maxCoin[left][right] = Math.max(maxCoin[left][right], maxCoin[i][k] + arrp*arr[k]);
                }
            }
        }

        return maxCoin[0][len+1];

    }
}
}
