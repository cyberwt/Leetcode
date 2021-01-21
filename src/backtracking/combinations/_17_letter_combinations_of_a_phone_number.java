package backtracking.combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * M1: BFS-iterative
 *
 * M2: DFS-backtracking
 *
 * 没写，理解了
 * 是按层构建，然后不停去取
 * 每层不停的被取，由题中给的map.get(index) 构成
 * 每层构建是，也是一个个可能的值构成
 * -- 没完全理解， stop！
 *
 * T:O(4^n) S:O(N)
 *
 * For DFS/ BFS, you can typically calculate the height of the calculation tree,
 * and then multiply the time complexity of each level of the calculation tree.
 * For this problem, if you press one button, you have 4 choice, if you press N times, you have to multiply N time to build the new String.
 *
 *
 * 1/20/21
 *
 * 为什么自己没有思路-> 是你懒了
 *
 * 这种backtracking -> 是基本加进去，再拿出来
 *
 *
 * 6/27/20.
 */
public class _17_letter_combinations_of_a_phone_number {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

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

    public List<String> letterCombinations2(String digits) {
        if(digits.equals("")) {
            return new ArrayList<String>();
        }

        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

    public static void main(String[] args){
        _17_letter_combinations_of_a_phone_number solution = new _17_letter_combinations_of_a_phone_number();

        List<String> test = solution.letterCombinations( "1234");
        System.out.println(test);
    }
}
