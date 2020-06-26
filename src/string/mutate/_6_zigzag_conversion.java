package string.mutate;

/**
 *
 *  按照新的给订规则再走一遍，注意限制条件： for(int n=numRows-2; i<s.length() && n>0; n--)
 *
 *  and StringBuilder is a class, it's need initialization!
 *
 *  T:O(N) S:O(N)
 *
 *  6/26/20.
 */
public class _6_zigzag_conversion {
    public String convert(String s, int numRows) {
        if(s== null || s.length() == 0 || numRows <=0){
            return "";
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int k=0; k<numRows; k++){
            sb[k] = new StringBuilder();
        }
        int i=0;
        while(i<s.length()){
            for(int m=0; i<s.length() && m<numRows; m++){
                sb[m].append(s.charAt(i++));
            }

            for(int n=numRows-2; i<s.length() && n>0; n--){
                sb[n].append(s.charAt(i++));
            }
        }

        for(int j=1; j<numRows; j++){
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        _6_zigzag_conversion solution = new _6_zigzag_conversion();
        System.out.println(solution.convert("PAHNAPLSIIGYIR",4));
    }
}
