package array.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 几个注意
 * > 新建的 要是Integer数组，compareTo才好用
 * >
 * Arrays.sort(n, new Comparator<Integer>){
 *     @override
 *     public int compare(Integer val1, Integer val2){
 *
 *     }
 * }
 *
 *
 * 8/18/20.
 */
public class _179_largest_number {
    public String largestNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        Arrays.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                String s1 = n1 + "" + n2;
                String s2 = n2 + "" + n1;
                //compareTo 方法
                //如果参数是一个按字典顺序排列等于该字符串的字符串，则返回值为0;
                //如果参数是按字典顺序大于此字符串的字符串，则返回值小于0;
                //如果参数是按字典顺序小于此字符串的字符串，则返回值大于0。
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(n[i]);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}
