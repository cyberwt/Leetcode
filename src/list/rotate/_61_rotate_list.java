package list.rotate;

import utils.ListNode;

/**
 *
 * M1: Brute force 超时
 *
 * M2: 快针得list长度， 然后pointer不断定位
 * 采用余数方式:
 * 1.count = len - k%len
 *
 * 7/4/20.
 */
public class _61_rotate_list {
    public ListNode rotateRight(ListNode head, int k) {
        //k > len
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        int len = 0;
        for(len=0; fast.next!=null; len++){
            fast = fast.next;// fast is tail
        }

        for(int j=0; j< len - k%len; j++){
            slow = slow.next;
        }


        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
