package list.replace;

import utils.ListNode;

/**
 *
 * Error:
 *
 * 1.最后一个 slow.next 要指过去
 *
 * 7/11/20.
 */
public class _83_remove_duplicates_from_sorted_list {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            if(fast.val == slow.val){
                fast=fast.next;
            }else{
                slow.next = fast;
                slow=slow.next;
                fast = fast.next;
            }

        }
        slow.next = fast;
        return dummy.next;
    }
}
