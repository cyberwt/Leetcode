package backtracking.combinations;

import java.util.LinkedList;
import java.util.List;

/**
 * 为什么自己没有思路-> 是你懒了
 *
 * 这种backtracking -> 是基本加进去，再拿出来
 *
 *
 * 6/27/20.
 */
public class _17_letter_combinations_of_a_phone_number {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res= new LinkedList<String>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        res.add("");
        while(res.peek().length() != digits.length()){
            String tem = res.poll();

            String val = map[digits.charAt(tem.length())-'0'];
            for(int i=0; i<val.length(); i++){
                res.add(tem+ val.substring(i,i+1));
            }
        }
        return res;
    }

    public static void main(String[] args){
        _17_letter_combinations_of_a_phone_number solution = new _17_letter_combinations_of_a_phone_number();

        List<String> test = solution.letterCombinations( "1234");
        System.out.println(test);
    }
}
