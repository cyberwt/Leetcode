package microsoft.oa;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_word_machine {
    public int wordMachine(String S) {
        Stack<Integer> stack = new Stack<>();
        List<String> items = Arrays.asList(S.split("\\s+"));
        for(String item : items) {
            if(item.equals("DUP")) {
                if(stack.isEmpty()) return -1;
                stack.push(stack.peek());
            } else if(item.equals("POP")) {
                if(stack.isEmpty()) return -1;
                stack.pop();
            } else if(item.equals("+")) {
                if(stack.size() < 2)
                    return -1;
                int add1 = stack.pop();
                int add2 = stack.pop();
                stack.push(add1 + add2);
            } else if(item.equals("-")) {
                if(stack.size() < 2)
                    return -1;
                int sub1 = stack.pop();
                int sub2 = stack.pop();
                stack.push(sub1 - sub2);
            } else {
                stack.push(Integer.parseInt(item));
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public static void main(String[] args) {
        oa_word_machine s = new oa_word_machine();
        System.out.println(s.wordMachine("13 DUP 4 POP 5 DUP + DUP + -"));
        System.out.println(s.wordMachine("5 6 + -"));
        System.out.println(s.wordMachine("13 DUP 4 POP 5 DUP + DUP + - POP POP"));
    }


}


