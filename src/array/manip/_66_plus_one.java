package array.manip;

import java.util.Arrays;

/**
 * 直接放到for循环里，规范计算，然后再跳出出
 *
 * 得到不符合条件的情况
 *
 *
 * 7/5/20.
 */
public class _66_plus_one {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            //不合法的时候，想返回什么
            return digits;
        }

        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] != 9){
                digits[i] +=1;
                return digits;
            }else{
                digits[i] =0;
            }
        }

        int[] arr = new int[digits.length+1];

        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args){
        _66_plus_one solution = new _66_plus_one();
        int[] num1 = {1,2,9};
        int[] test = solution.plusOne(num1);
        System.out.println(Arrays.toString(test));
    }
}
