package list.iterate;

import utils.ListNode;

import java.util.Stack;

/**
 * Stack 构建，从最低位开始操作
 *
 * 每位依次操作
 *
 * 1/31/21
 *
 * M1:
 * 特殊数据结构，stack 往里面放值，就变成回溯的另一种
 *
 * M2: recursive
 * Get diff 去建leading value
 *
 * 9/20/20.
 */
public class _445_add_two_numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }

    int carry = 0;

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode res;
        int len1 = getLen(l1), len2 = getLen(l2);
        if (len1 < len2) {
            res = add(l1, l2, len2 - len1);
        } else {
            res = add(l2, l1, len1 - len2);
        }
        if (carry > 0) {
            ListNode res1 = res;
            res = new ListNode(carry);
            res.next = res1;
        }
        return res;
    }

    public int getLen(ListNode l1) {
        int len = 0;
        while (l1 != null) {
            len++;
            l1 = l1.next;
        }
        return len;
    }

    //l2.length - l1.length == diff;
    public ListNode add(ListNode l1, ListNode l2, int diff) {
        if (l1.next == null && l2.next == null) {
            int sum = l1.val + l2.val;
            carry = sum / 10;
            return new ListNode(sum % 10);
        }
        ListNode res, next;
        int sum;
        if (diff == 0) {
            next = add(l1.next, l2.next, 0);
            sum = l1.val + l2.val + carry;
        } else {
            next = add(l1, l2.next, diff - 1);
            sum = carry + l2.val;
        }
        carry = sum / 10;
        res = new ListNode(sum % 10);
        res.next = next;
        return res;
    }
}
