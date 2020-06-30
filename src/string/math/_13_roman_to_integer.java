package string.math;

import java.util.HashMap;

/**
 * 按位转化，按位得值
 *
 * T:O(N) S:O(1)
 *
 * 6/26/20
 */
public class _13_roman_to_integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0;
        for(int i=0; i<s.length()-1; i++){
            char c = s.charAt(i);
            int next = map.get(s.charAt(i+1));
            int cur = map.get(c) <next ? map.get(c)*(-1): map.get(c);
            res += cur;
        }
        res += map.get(s.charAt(s.length()-1));
        //在加上最后一个值
        return res;
    }
    public static void main(String[] args) {
        _13_roman_to_integer solution = new _13_roman_to_integer();
        System.out.println(solution.romanToInt("IVXLC"));
    }
}
