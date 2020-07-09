package binarySearch.math;

/**
 *
 * 1.while循环判定清：while(L<=R)
 *
 * 2.防溢出：mid = L+(R-L)/2;
 *
 * 3.提前保存可能值： 以防突然结束 res = mid;
 *
 * T:O(logN) S:O(1)
 *
 * 7/5/20.
 */
public class _69_sqrt_x {
    public int mySqrt(int x) {
        int L = 1, R = x;
        int mid = 0;
        int res = 0;
        while(L<=R){
            //什么时候会出现 溢出条件
            mid = L+(R-L)/2;
            if(mid == x/mid){
                return mid;
            }else if(mid < x/mid){
                res = mid;
                L = mid+1;
            }else{
                R = mid-1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _69_sqrt_x solution = new _69_sqrt_x();

        double res = solution.mySqrt(101);
        System.out.println(res);
    }
}
