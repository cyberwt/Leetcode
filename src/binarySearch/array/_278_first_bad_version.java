package binarySearch.array;

/**
 *
 * 典型的二分法，但为什么是这么写：
 *
 *  left<right
 * > right = mid
 *   left = mid+1
 *
 *
 * T:O(lgN) S:O(1)
 *
 *
 *
 * 2/21/21.
 */
public class _278_first_bad_version {
    public int firstBadVersion(int n) {
        if(n<1){
            return n;
            // throws InvalidParameterException();
        }

        int left=1, right=n;
        while(left < right){
            int mid = (right-left)/2 + left;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
