package binarySearch.array;

/**
 * 本身数组是有规律的，正常对应的结果是 nums[i] = i-1
 * 我不管前面那个数少多少，我看我本身和缺的是
 * missing k is nums[i]（前面的值就包含了缺失的值） - i -1 >= k
 *
 * https://leetcode-cn.com/problems/kth-missing-positive-number/solution/duo-chong-jie-fa-by-dao-chang-3/、
 *
 * 由先行，可以变成二分 - 利用arr[i]与其下标i关系
 *
 * 4/25/21.
 */
public class _1539_Kth_missing_positive_number {

    int findKthPositive(int[] arr, int k) {
        int i,n = arr.length;
        for(i=0;i<n;i++){
            if(arr[i]-i-1>=k){
                return k+i;
            }
        }
        return k+i;//亦可写成：k+n，只不过写成k+i方便理解下面一个解法
    }

    int findKthPositive2(int[] arr, int k) {
        int left = 0, right = arr.length, mid = 0;
        while(left<right){
            mid = left + (right-left)/2;
            if(arr[mid]-mid >= k+1){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return k + left;
    }

}
