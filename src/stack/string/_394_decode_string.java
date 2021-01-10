package stack.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * K_P:
 * 1. Character.isDigit(char) || int val= charVal -'0'
 * 2. 怎么构建，何时弹出
 * >数字的构建：直到while 拉满
 * while(Character.isDigit(s.charAt(idx)) )
 *
 * >String 字符串的构建 []  ->解决corner case == 3[a2[c]]
 * [ 后的是res,
 *
 * ] 就要用[ 前的sb.append(res x no.number) 才是完整的一组
 *
 *
 *
 * m2 dfs
 *
 * 更简洁了，
 * 直接切分成越来越小，遇见[ 直接切分
 *
 *
 *  8/24/20.
 */
public class _394_decode_string {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public String decodeString2(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return helper(queue);
    }

    public String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c= queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) sb.append(sub);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
