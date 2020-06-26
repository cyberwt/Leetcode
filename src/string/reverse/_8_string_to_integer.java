package string.reverse;

/**
 * 标准数字处理流程：
 * 1. 查前值非零非空
 * 2. Sign falg 标注
 * 3. 用/ ，% 向结局里进位
 * 4. 其中查非法字符，非溢出
 *
 * T:O(N) S:O(1)
 * 6/26/20.
 */
public class _8_string_to_integer {
    public int myAtoi(String str) {
        //CC:
        if(str == null || str.length() ==0){
            return 0;
        }
        int res=0;
        int index = 0;
        // 查前面空值
        while(index < str.length() && str.charAt(index) == ' '){
            index++;
        }
        //判断正负
        int sign = 1;
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            sign = str.charAt(index) == '-'? -1:1;
            index++;
        }
        //查非法字符， 进位变换
        while(index <str.length()){
            int digit = str.charAt(index)-'0';
            if(digit <0 || digit >9){
                break;
            }
            if( (res> Integer.MAX_VALUE/10) || (res == Integer.MAX_VALUE/10 && (digit> Integer.MAX_VALUE %10))){
                res = sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
                return res;
            }

            res = res*10 + digit;
            index++;
        }
        return res*sign;
    }
}
