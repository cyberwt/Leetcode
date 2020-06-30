package list;

import utils.ListNode;

/**
 * 按位运算，每一位判断下非空
 *
 * BF: ListNode next = 得是一个 ListNode
 *
 * T:O(Math.max(m,n)) S:O(Math.max(m,n))
 *
 * 6/21/20.
 */
public class _2_add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //没有明确的Corner Case可以要
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry=0;

        // what's the probelm here if I choose not stop
        while(l1 != null || l2!=null){
            int val1 = l1==null ? 0:l1.val;
            int val2 = l2==null ? 0:l2.val;
            int sum = carry+val1+val2;
            carry = sum/10;
            ListNode next = new ListNode(sum%10);
            head.next = next;
            head = head.next;
            l1 = l1==null? l1:l1.next;
            l2 = l2==null? l2:l2.next;
        }

        if(carry ==1){
            head.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        _2_add_two_numbers solution = new _2_add_two_numbers();
        ListNode.print(solution.addTwoNumbers(ListNode.createTestData("[1,2,3]"),
                ListNode.createTestData("[5,6,7]")      ));
    }
}
