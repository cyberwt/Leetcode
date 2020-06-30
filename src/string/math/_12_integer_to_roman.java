package string.math;

/**
 * while + for 里面做减法
 *  循环很有意思
 *
 *
 * 6/26/20.
 */
public class _12_integer_to_roman {
    public String intToRoman(int num) {
        String[] str = {"M", "CM","D","CD", "C", "XC","L","XL","X","IX","V","IV","I"};
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9,5,4,1};
        StringBuilder sb = new StringBuilder();
        while(num>0){
            for(int i=0; i<vals.length; i++){
                if(num - vals[i] >=0){
                    sb.append(str[i]);
                    num -= vals[i];
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        _12_integer_to_roman solution = new _12_integer_to_roman();
        System.out.println(solution.intToRoman(12345));
    }
}
