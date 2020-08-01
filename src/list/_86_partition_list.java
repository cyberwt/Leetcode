package list;

import utils.ListNode;

/**
 *
 * 因为ListNode 不会占空间，所以直接简单的分成两堆，放min, max
 *
 * 再注意一下 首尾的连接情况
 *
 * 7/13/20.
 */
public class _86_partition_list {
    public ListNode partition(ListNode head, int x) {
        //怎么把握住它能转向这边呢
        //链表的特殊性，不占空间，只动指针就可以

        ListNode min_head = new ListNode(-1);
        ListNode min = min_head;
        ListNode max_head = new ListNode(-1);
        ListNode max = max_head;

        ListNode cur = head;
        while(cur!=null){
            if(cur.val < x){
                min.next = cur;
                min = min.next;
            }else{
                max.next = cur;
                max = max.next;
            }
            cur = cur.next;
        }

        min.next = max_head.next;
        max.next = null;
        return min_head.next;

    }
}
