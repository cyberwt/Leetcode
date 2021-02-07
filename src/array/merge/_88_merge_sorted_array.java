package array.merge;

/**
 *  index的比较, index1,2不合规时  合规时的 4种情况
 *  T:O(N) S:O(1)
 *
 *  1/27/21
 *
 *  M1: 反解，分别往后放
 *
 *  7/13/20.
 */
public class _88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //将 nums1 的数字全部移动到末尾
        for (int count = 1; count <= m; count++) {
            nums1[m + n - count] = nums1[m - count];
        }
        int i = n; //i 从 n 开始
        int j = 0;
        int k = 0;
        //遍历 nums2
        while (j < n) {
            //如果 nums1 遍历结束，将 nums2 直接加入
            if (i == m + n) {
                while (j < n) {
                    nums1[k++] = nums2[j++];
                }
                return;
            }
            //哪个数小就对应的添加哪个数
            if (nums2[j] < nums1[i]) {
                nums1[k] = nums2[j++];
            } else {
                nums1[k] = nums1[i++];
            }
            k++;
        }
    }
}
