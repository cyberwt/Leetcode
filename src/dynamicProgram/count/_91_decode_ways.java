package dynamicProgram.count;

/**
 *
 *
 * E:
   巧妙，因为dp[1] 只用加1种可能，且不能依靠dp[i-2]

   dp[i] = i>=2?dp[i-2]:1;
 *
 *
 * T:O(N)  S:O(N)
 *
 * 3/23/21
 *
 * > 9.7
 * Error:
 * 1. 每一次位运算 都要取'0'
 * 2.没理解每次为是么是
 *
 * dp[i] += dp[i-1] 之后不在有运算了
 *
 *
 * 巧妙的取两个不同值
 *
 * dp[i-1] dp[i-2] 分别在index有效的情况下 对 dp[i] 的影响
 *
 *  if(cur>0 ){
       dp[i] += dp[i-1];
    }

    if(val>=10 && val <=26){
       dp[i] = i>=2?dp[i-2]:1;
    }


 *
 * 7/14/20.
 */
public class _91_decode_ways {
    public int numDecodings(String s) {
        if(s== null || s.length() == 0){
            return 0;
        }
        int res = 0;
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0'? 0:1;

        for(int i=1; i<s.length(); i++){
            int pre = s.charAt(i-1) - '0';
            int cur = s.charAt(i) - '0';
            int val = pre*10 + cur;
            if(val>=10 && val <=26){
                dp[i] = i>=2?dp[i-2]:1;
            }
            if(cur>0 ){
                dp[i] += dp[i-1];
            }

        }
        return dp[s.length()-1];
    }
}
