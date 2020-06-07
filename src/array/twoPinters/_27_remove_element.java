package array.twoPinters;

/**
 *  Two pointers: pre & cur
 *
 *  Pre留在原地，Cur向前找不相等的值
 *
 *  Tri:
 *  it needs logical judgement from first element whcih
 *  could equal to the val
 *
 *
 *  S: O(1) T:O(N)
 *
 *
 * 6/7/20
 */
public class _27_remove_element {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //Trick:
        int pre = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != val) {
                nums[pre++] = nums[cur];
            }
            cur++;
        }
        return pre;
    }

    public static void main(String[] args){
        _27_remove_element solution = new _27_remove_element();
        int[] test_case = {1,1,1,1,2,2,2,3};
        int res = solution.removeElement( test_case,2);
        System.out.println(res);
    }
}
