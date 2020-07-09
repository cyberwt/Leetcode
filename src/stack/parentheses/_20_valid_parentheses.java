package stack.parentheses;

import java.util.Stack;

/**
 * 想好，是要判断栈空，还是loop string
 *
 * 先做弹出判断，再压栈 - 肯定不能先压，再弹
 *
 * T:O(N) S:O(1)
 *
 * 6/28/20.
 */
public class _20_valid_parentheses {
    public boolean isValid(String s) {
        //一个基本的Stack局
        if(s==null || s.length() ==0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        int i=0;
        stack.push(s.charAt(i));
        i++;
        while(i<s.length() ){
            char val = s.charAt(i);
            System.out.println(val + " ");
            //stack.push(val);
            if(!stack.isEmpty() && ( (stack.peek() == '(' && val==')') || (stack.peek() == '[' && val==']') || (stack.peek() == '{' && val=='}'))){
                stack.pop();
            }else{
                stack.push(val);
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _20_valid_parentheses solution = new _20_valid_parentheses();
        System.out.println(solution.isValid("[]{}"));
    }

}
