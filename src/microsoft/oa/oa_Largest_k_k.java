package microsoft.oa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_Largest_k_k {
    public static void main(String[] args) {
        int[] nums1 = { 3, 2, -2, 5, -3 };
        int[] nums2 = { 1, 2, 3, -4 };
        System.out.println(largestNum(nums1));
        System.out.println(largestNum(nums2));
        System.out.println("-------------------------------------");
        System.out.println(largestNum2(nums1));
        System.out.println(largestNum2(nums2));
    }

    private static int largestNum(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(-nums[i]);
            if(set.contains(nums[i])) {
                res = Math.max(res, Math.abs(nums[i]));
            }
        }
        return res;
    }

    private static int largestNum2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length -1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum == 0) {
                res = Math.max(res, Math.max(nums[l], nums[r]));
                l++;
                r--;
            }
            else if(sum < 0) {
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}
