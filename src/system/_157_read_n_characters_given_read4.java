package system;




/*
read4(tem)
传进被卸船，返回写出几个
我就做一个大小比较，去看我到底要去放多少，巧妙

 */


public class _157_read_n_characters_given_read4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        boolean eof = false;
        char[] tem = new char[4];
        while(!eof && total<n){
            int count = read4(tem);
            eof = count <4;
            int left = Math.min(count, n-total);
            for(int i=0; i<left; i++){
                buf[total++] = tem[i];
            }
        }
        return total;
    }

    public int read4(char[] tem){
        return 4;
    }
}
