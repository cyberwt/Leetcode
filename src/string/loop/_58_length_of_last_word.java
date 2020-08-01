package string.loop;

/**
 *
 * 基础for-loop  <=> while
 *
 * 考虑好CC, 边界
 *
 * T:O(N) S:O(1)
 * 7/3/20.
 */
public class _58_length_of_last_word {
    public int lengthOfLastWord(String s) {
        //CC corner case
        if(s== null || s.length()==0){
            return 0;
        }
        int res = 0;
        int len = s.length()-1;
        while(len >=0 && s.charAt(len) == ' '){
            len--;
        }
        while(len>=0 && s.charAt(len) != ' '){
            len--;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        _58_length_of_last_word solution = new _58_length_of_last_word();
        System.out.println(solution.lengthOfLastWord("[]{}"));
        System.out.println('a' - 'A');

    }

}
