package stack.string;

import java.util.Stack;

/**
 *
 * 一个典型栈结构的理解，用if 选项处理不同情况
 *
 * 五种情况 '+' '-' '*' '/' 'Integer.parseInt()'
 *
 * 7/17/20.
 */
public class _150_evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        for(String token: tokens){
            int a, b;
            if(token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(token.equals("-")){
                a=stack.pop();
                b=stack.pop();
                stack.push(b-a);
            }else if(token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(token.equals("/")){
                a=stack.pop();
                b=stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        _150_evaluate_reverse_polish_notation solution = new _150_evaluate_reverse_polish_notation();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
