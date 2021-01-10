package list.sort;

import utils.ListNode;

/**
 *
 * M1: iterate
 * 设置dummy node， 一个一个Iterate 的向内插
 * Error:
 * 此dummy node不能与head 相连，因为是插入关系，否则会和第一个node成环
 *
 * on 8/10/20.
 */
public class _147_insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        //dummy.next = head;
        ListNode cur = head;
        ListNode next;
        ListNode pre;
        while(cur!=null){
            next = cur.next;
            pre = dummy;
            while(pre.next!=null && pre.next.val<cur.val){
                pre = pre.next;
            }
            // 三种pre 值的取得 都被涵盖了么
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        return dummy.next;
    }
}
