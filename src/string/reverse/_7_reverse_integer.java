package string.reverse;



/**
 *
 * MIN_value 是 8 结尾更大
 *
 * CC 的分析：
 * 1. Sign flag标好
 * 2. if(x>0 && (res > Integer.MAX_VALUE/10 || ( (res == Integer.MAX_VALUE/10) && (x>Integer.MAX_VALUE%10))))
 * 3. 如果是 0开头，要除掉，不除也行
 *
 * 8 is more interested
 *
 * 6/26/20.
 */
public class _7_reverse_integer {

    public int reverse(int x) {
        //if(x == 0) return 0;
        if(x==0 || x==Integer.MIN_VALUE) return 0;

        int sign = 1;
        if(x<0){
            x=-x;
            sign=-1;
        }
        //除掉溢出值
        while(x%10 == 0){
            x /= 10;
        }
        //然后放到里面不变,计算何时溢出
        int res=0;
        while(x>0){
            int digit = x %10;
            x /= 10;
            res = res*10+digit;
            if(x>0 && (res > Integer.MAX_VALUE/10 || ( (res == Integer.MAX_VALUE/10) && (x>Integer.MAX_VALUE%10)))){
                return 0;
            }
        }

        return res*sign;
    }

    public static void main(String[] args) {
        _7_reverse_integer solution = new _7_reverse_integer();
        System.out.println(solution.reverse(123));
    }
}
