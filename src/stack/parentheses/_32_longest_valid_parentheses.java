package stack.parentheses;

import java.util.Stack;

/**
 *
 * M1: 双循环
 * 意义：夹的是 [i,j] 的值， 然后以 每一个i 为起点，往后扫
 * T:O(N^2) S:O(1)
 *
 * M2: Stack 存取数
 * 只有在符合条件的时候，我才弹出: if(!stack.isEmpty() && s.charAt(i) == ')' && s.chatAt(stack.peek()) == '(')
 * T:O(N) S:O(N)
 *
 * M3: 理解dp
 * https://leetcode.com/problems/longest-valid-parentheses/discuss/14278/Two-Java-solutions-with-explanation.-Stack-and-DP.-Short-and-easy-to-understand.
 *
 * 6/19/20.
 */
public class _32_longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        int res = 0;
        int pre =0;
        for(int i=0; i<s.length(); i++){
            int count = 0;
            for(int j=i; j<s.length(); j++){
                //从i开始，一步一步确认是否为最优
                if(s.charAt(j) == '('){
                    count++;
                }else{
                    count--;
                }
                if(count<0){
                    break;
                };

                if(count == 0){
                    res = Math.max(res, j-i+1);
                }

            }
        }

        return res;
    }

    public int longestValidParentheses2(String s) {
        if(s==null || s.length() ==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        //stack stores index
        int res=0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _32_longest_valid_parentheses solution = new _32_longest_valid_parentheses();
        System.out.println(solution.longestValidParentheses("[]{}"));
    }
}
