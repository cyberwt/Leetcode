package system;

/**
 *
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
