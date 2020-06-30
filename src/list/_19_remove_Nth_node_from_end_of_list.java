package list;

import utils.ListNode;

/**
 *  设置 dummy node ,为了：长度等于 1 和删除头结点的时候需要单独判断
 *
 *  M1: 正常数长度，然后不断--，来判断
 *
 *  M2: 快慢指针，先reach 到结尾
 *
 *
 *  但都一样 T:O(N) S:O(1)
 *
 *  6/27/20.
 */
public class _19_remove_Nth_node_from_end_of_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // Two pointers

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n ; i++) {
            fast = fast.next;
        }

        while(fast!= null){
            slow = slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        _19_remove_Nth_node_from_end_of_list solution = new _19_remove_Nth_node_from_end_of_list();
        ListNode.print(solution.removeNthFromEnd2(ListNode.createTestData("[1,2,3,4,5,6,7]"),4));
    }
}
