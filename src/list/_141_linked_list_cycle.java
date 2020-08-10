package list;

import utils.ListNode;

/**
 *  while(fast!=null && fast.next != null) means can be the last (null) or the node before it
 *
 *  ? 思考一下，为什么你第一次解错了
 *  用了if else, 导致只有一条路径，跳到while时，流局了
 *
 * 8/7/20.
 */
public class _141_linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        // 快慢指针，记录slow,如果fast 到底 则没有重复
        // 不需要 dummy node的帮助

        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;

        }
        return false;
    }
}
