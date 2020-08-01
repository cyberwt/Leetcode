package list.replace;

import utils.ListNode;

/**
 * Error:
 * 1. slow 下一个并不一定有效，所以不能在
 *
 *  if(slow.next != fast) 动slow
 *      slow.next = fast.next
 *      fast =slow.next
 *
 *
 * 7/12/20.
 */
public class _82_remove_duplicates_from_sorted_list_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;

        while(fast != null){

            while(fast != null && fast.next!= null && fast.val == fast.next.val){
                fast = fast.next;
            }

            if(slow.next!=fast){
                //!不能动slow, 因为slow
                slow.next = fast.next;
                fast = slow.next;

            }else{
                slow = slow.next;
                fast = fast.next;
            }

        }

        return dummy.next;
    }

}
