package stack.parentheses;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 经典栈题
 *
 * M1: 不断Iterate然后根据条件进出 => Stack<Character>
 *
 * 是限制'(' & ')' 的进栈
 *
 * if(c == ')' && cnt > 0) 限制 ')'
 *
 *
 * if( c == '(' && count > 0) 限制 '('
 *
 *
 * M2:
 *    只有'(' 才进栈， '('验证是否可能的出栈
 *
 *
 * 优化很妙，用一个String, 代替了每次都要进出栈， 栈就可以记录匹配情况 => Stack<Integer>
 *  str.split("");
 *  String.join("", arr)
 *
 * T:O(N) S:O(n)
 *
 *
 *
 *
 * 4/2/21     6/30/20.
 */
public class _1249_minimum_remove_to_make_valid_parentheses {
    public String minRemoveToMakeValid(String s) {
        if(s== null || s.length() == 0){
            return "";
        }

        Stack<Character> stack = new Stack<Character>();
        int count =0, con = 0;
        for(int i=0; i< s.length(); i++){
            char val = s.charAt(i);
            if(val == '('){
                count++;
                stack.push(val);
            }else if(val == ')' && count>0){
                count--;
                stack.push(val);
                con++;
            }else if(val !='(' && val!=')'){
                stack.push(val);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(Character cha: stack){
            System.out.println(cha + " pp");
            if(cha == '(' && con>0){
                sb.append(cha);
                con--;
            }
            if(cha != '('){
                sb.append(cha);
            }
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if ("(".equals(arr[i])) {
                stack.push(i);
            } else if (")".equals(arr[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = "";
                }
            }
        }
        while(!stack.isEmpty()) {
            arr[stack.pop()] = "";
        }
        return String.join("", arr);
    }

    public static void main(String[] args) {
        _1249_minimum_remove_to_make_valid_parentheses solution = new _1249_minimum_remove_to_make_valid_parentheses();
        System.out.println(solution.minRemoveToMakeValid("saf(vds)vsdv((()"));


        Deque<String> deque = new LinkedList<>();

        deque.add("element 0");
        deque.add("element 1");
        deque.add("element 2");

        Iterator<String> iterator = deque.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
