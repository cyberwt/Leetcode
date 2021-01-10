package list.iterate;

import utils.ListNode;

import java.util.Stack;

/**
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
        if(l1 == null || l2 == null){
            return null;
        }
        ListNode cur = null;
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        // can I move the head of original stack
        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        int flag = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()){
                ListNode node1 = stack1.pop();
                flag += node1.val;
            }

            if(!stack2.isEmpty()){
                ListNode node2 = stack2.pop();
                flag += node2.val;
            }
            ListNode node = new ListNode(flag%10);
            node.next = cur;
            cur = node;
            flag = flag/10;
        }
        if(flag !=0){
            ListNode node = new ListNode(1);
            node.next = cur;
            cur = node;
        }
        return cur;
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
