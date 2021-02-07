package math.system;

/**
 * 无符号右移>>>，得到new result
 * each time we take a look at the last four digits of
 binary verion of the input, and maps that to a hex char
 shift the input to the right by 4 bits, do it again
 until input becomes 0.

 *
 * 1/30/21.
 */
public class _405_convert_a_number_to_hexadecimal {
    public String toHex(int num) {
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        if(num == 0){
            return "0";
        }
        String result = "";
        while(num != 0){
            result = map[(num&15)] + result;
            num = num>>>4;
        }
        return result;
    }
}
