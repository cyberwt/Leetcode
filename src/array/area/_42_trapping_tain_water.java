package array.area;

/**
 * How to improve?
 *
 * > find the higher wall, and use the left and right tank to combine the results
 *
 * > T:O(N) S:O(1)
 *
 * 4/18/21
 *
 *
 * 考虑多了，其实不用特殊考虑 0,len-1 的位置
 * 直接：Math.min(leftMax[k], rightMax[k])-height[k]
 *
 * 03/13/21
 *
 *
 * 从左到右，从右到左
 * 木桶原理找出 maxLeft, maxRight 与当前值相夹(减
 *
 * T:O(N) S:O(N)
 *
 *
 * 6/15/20.
 */
public class _42_trapping_tain_water {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            max = Math.max(height[i], max);
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;
        for(int j=len-1; j>=0; j--){
            max = Math.max(height[j], max);
            rightMax[j] = max;
        }
        int res = 0;
        for(int k=0; k<len; k++){
            res +=  Math.min(leftMax[k], rightMax[k])-height[k];
        }
        return res;
    }

    public static void main(String[] args){
        _42_trapping_tain_water solution = new _42_trapping_tain_water();
        int[] test_case = {1,1,1,0,2,2,2,3};
        int res = solution.trap( test_case);
        System.out.println(res);
    }

    public int trap2(int[] height) {
        if (height.length <= 2) return 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int leftMax = height[0];
        int water = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water += leftMax - height[i];
            }
        }

        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water += rightMax - height[i];
            }
        }

        return water;
    }
}
