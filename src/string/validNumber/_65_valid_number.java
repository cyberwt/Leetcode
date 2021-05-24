package string.validNumber;

/**
 * 定义：
 * numberSeen, numberAfterE, eSeen
 * 不断把他们的判断结果 扔到for loop 里面，看是否符合定义规范
 *
 * 7/5/20.  4/29/21
 */
public class _65_valid_number {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        s.trim();
        boolean eSeen = false, dotSeen = false, numberSeen = false;
        int index = 0;
        // 怎么排兵布阵呐
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( (c == '+' || c == '-') ){
                if (i != 0 &&  Character.toUpperCase(s.charAt(i-1)) != 'E') {
                    System.out.println(s.charAt(i-1));
                    return false;
                }
            }else if(c == 'e' || c == 'E'){
                if(eSeen || !numberSeen) return false;
                eSeen = true;
                numberSeen = false;
            }else if(c == '.'){
                if(dotSeen || eSeen ) return false;
                dotSeen = true;
            }else if(Character.isDigit(c)){
                numberSeen = true;
            }else {
                return false;
            }
        }

        return numberSeen;
    }


}
