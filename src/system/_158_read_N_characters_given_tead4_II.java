package system;

/**
 *
 *
 * 就是buffCnt 一直和buffPtn  比较
 *
 * 理得不是那么清楚哎
 * buffCnt buffPtn 用if 表示好了
 *  while(count<n && buffPtn < buffCnt)
 *
 * 3/30
 *
 * 1。里面那个while用的很巧妙 两个限定条件，index<n && buffPtn < buffCnt
 * 2。能够break掉整个循环的条件: if(buffPtn<4) break;
 * 3。理解整个归零的思想
 *    if(buffPtn == buffCnt){
          buffPtn =0;
      }
 *
 *
 * 3/16/21
 *
 * 怎么想好 buffLeft and buffCnt 的置换关系
 *
 * 在这时，替换：
 * if(buffPtn<4) break;
   if(buffPtn == buffCnt){
       buffPtn =0;
   }
 *
 *
 *
 * 3/6/2021
 *
 * //
 *理解这两个变量的含义
 *
 * 太巧妙了
 * while(count < n && buffPtn < buffCnt )
 *
 *
 * 2/18/21.
 */
public class _158_read_N_characters_given_tead4_II {
    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */

        int buffCnt = 0;
        int buffPtn = 0;
        char[] tem = new char[4];
        public int read(char[] buf, int n) {
            int count = 0;
            while(count < n){
                // 如果上次没读完，继续读下去
                if(buffPtn == 0){
                    buffCnt = read4(tem);
                }
                // 安排新位置，在这种条件的限制下
                while(count<n && buffPtn < buffCnt){
                    buf[count++] = tem[buffPtn++];
                }
                //没数，就停
                if(buffPtn<4) break;
                // 什么时候要归零
                if(buffPtn == buffCnt){
                    buffPtn =0;
                }
            }
            return count;
        }
    }
}
