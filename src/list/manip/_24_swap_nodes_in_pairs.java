package list.manip;

import utils.ListNode;

/**
 * Created by weitong on 6/4/20.
 */
public class _24_swap_nodes_in_pairs {

// Solution 1: iteration

    public ListNode swapPairs(ListNode head) {
        // CC
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur, next;
        while(pre.next != null && pre.next.next != null){
            cur = pre.next;
            next = cur.next;
            // move pointers from back to front
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            // get the right position as the next mover
            pre = cur;
        }
        return dummy.next;
    }

// Solution 2: recursion
    public ListNode swapPairs2(ListNode head) {
        // CC
        if(head == null || head.next == null){
            return head;
        }
        // swapping the first and second
        ListNode second = new ListNode(head.val);
        ListNode first = new ListNode(head.next.val);
        first.next = second;

       // recursively swap the next 2 items in the linked list till the end of list
        ListNode recursedList = swapPairs(head.next.next);

        second.next = recursedList;

        return first;
    }

    public static void main(String[] args) {
        _24_swap_nodes_in_pairs solution = new _24_swap_nodes_in_pairs();
        ListNode.print(solution.swapPairs2(ListNode.createTestData("[1,2,3,4,5,6,7]")));
    }

}

