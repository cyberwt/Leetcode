package stack.parentheses;

import java.util.Stack;

/**
 *
 * 太巧妙了，惊喜！
 *
 * 理解这个判断: 除了'(' 都需要进行，operator和 num 的复原 还有一种情况是 i>=s.length() 也要判断
 *
 * 4/3/21.
 */
public class _772_basic_calculator_III {
    int i=0;
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char operator = '+';
        int num = 0;
        while(i < s.length()) {
            char c = s.charAt(i++);
            if(Character.isDigit(c)) num = num*10+(c-'0');
            if(c == '(') num = calculate(s);
            if(i>= s.length() || c =='+' || c =='-' || c =='/' || c== '*' || c == ')'){
                if(operator == '+') stack.push(num);
                else if(operator == '-') stack.push(-num);
                else if(operator == '*') stack.push(stack.pop()*num);
                else if(operator == '/') stack.push(stack.pop()/num);
                operator = c;
                num = 0;
            }
            if(c ==')') break;
        }
        return stack.stream().mapToInt(x->x).sum();
    }
}
