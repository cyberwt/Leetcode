package array.cannikin;

/**
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

}
