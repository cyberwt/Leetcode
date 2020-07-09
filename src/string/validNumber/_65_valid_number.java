package string.validNumber;

/**
 * 定义：
 * numberSeen, signSeen, numberAfterE, eSeen
 * 不断把他们的判断结果 扔到for loop 里面，看是否符合定义规范
 *
 * 7/5/20.
 */
public class _65_valid_number {
    public boolean isNumber(String s) {
        // For loop 不断判断

        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }


}
