package string.manip;

/**
 * 一道简单地进制换算题
 *
 * 8/16/20.
 */
public class _171_excel_sheetc_column_number {
    public int titleToNumber(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        int res=0;
        for(int i=0; i<s.length(); i++){
            int val = (s.charAt(i)-'A'+1);
            res = res*26+val;
        }
        return res;
    }
}
