package math.system;

/**
 *
 * real index start from [0], so don't forget n--;
 *
 * 1/30/21.
 */
public class _168_excel_sheet_column_title {
    public String convertToTitle(int n) {
        if(n == 0){
            return "";
        }
        n--;
        return convertToTitle(n/26) + (char)(n%26 + 'A');
    }
}
