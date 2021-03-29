package array.area;


/**
 *
 * res = Math.min(height[left], height[right]) * (right -left)
 *
 * we can do two loops to get the res result, but actually, we can drop the value after
 *
 * (ai, aj) -> if( nums[ai]< nums[aj])
 * S1 = ai*(aj-ai)
 * S2 <= ai*(a?-ai)
 *
 * normally
 *
 *
 *
 *
 *  T: O(N) S:O(1)
 * 3/13/21 - one passed
 */





/**
 *  6/26/20.
 */
public class _11_container_with_most_water {

    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int res=0;
        int left = 0, right = height.length-1;
        while(left < right){
            res = Math.max(res,Math.min(height[left], height[right]) * (right -left));
            if(height[left]> height[right] ){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _11_container_with_most_water solution = new _11_container_with_most_water();
        System.out.println(solution.maxArea(new int[]{123,34,23,12,431,32,4}));
    }
}
