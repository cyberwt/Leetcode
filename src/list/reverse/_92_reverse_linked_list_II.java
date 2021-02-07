package list.reverse;

import utils.ListNode;

/**
 * Error:
 * 1. 没设dummy node
 *  为什么需要:
 * a. if m = 1, 不往后做
 * b. return dummy.next not head!
 *
 * 2.循环这儿没写错，但复杂了
 * a.直接
 *
 *
 * 2/6/21
 *
 * Iterative:
 * 没做出来的原因，想复杂了，想掏出start->end 然后再放回去， listnode 这么操作并不容易
 *
 * 是怎么一步一步换过去的，是pre不变，新的node 接在pre后边，start也不变，一直往后接下一个要被移动的值
 *
 * 巧妙，巧妙
 *
 * 9/20/20.
 */
public class _92_reverse_linked_list_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=1; i<=m-1; i++){
            pre = pre.next;
        }
        ListNode start = pre.next, then = start.next;
        for(int i=0; i<n-m;i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;

    }
}
