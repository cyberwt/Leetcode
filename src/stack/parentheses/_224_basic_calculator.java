package stack.parentheses;

import java.util.Stack;

/**
 * a. (时，入栈 =>  塞入'result'as number , 'sign' as '+/-' , 并且复原
 * b. ）时，出栈 =>蹦出来 result to calculate
 * c. +,- ，record sign
 * d. it needs a number
 *
 * 5/2
 *
 *
 * 1. 先算出sum / 并记录result
 * 2. '+', '-' 只用管sign
 * 3. 遇到'('时, stack.push(result), stack.push(sign), !全部复原 result=0, sign =1
 * 4 ')'时, result = result * stack.pop() + stack.pop();
 *
 * 4/3/21.
 */
public class _224_basic_calculator {
    public int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = 0;
                while (i < len && Character.isDigit(s.charAt(i ))) {
                    sum = sum * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                result += sum * sign;
            }else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {

                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }

}
