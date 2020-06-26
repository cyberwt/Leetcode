package string;

import java.util.Stack;

/**
 *
 * Parentheses 通用stack 来做
 *
 * T:O(N)  S:O(N) -worst case, take up the stack
 *
 * 6/18/20.
 */
public class _20_valid_parentheses {
    public boolean isValid(String s) {
        if( s == null || s.length() ==0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char tem = s.charAt(i);
            if(tem == '{' || tem == '[' || tem == '('){
                stack.push(tem);
            }else{
                if(stack.empty()) return false;
                if( (tem == '}' && stack.peek() == '{') ||(tem == ')' && stack.peek() == '(') || (tem == ']' && stack.peek() == '[') ){
                    stack.pop();
                }else{
                    return false;
                }

            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        _20_valid_parentheses solution = new _20_valid_parentheses();
        System.out.println(solution.isValid("[]{}"));
    }
}
