package list.reverse;

import utils.ListNode;

/**
 * 9.20
 * 理解好 recursive and iterative 的不同
 *
 * M2: 想多了
 * newHead 置为永恒的出口
 * 然后不段为当前node做置换
 *
 * M1: 正看也很有意思
 * error:
 * > next 值预留出来，不然会被破坏
 * > 其实返回的是pre,而不是当前已经是null的cur
 *
 *
 * M1:
 * next 为预留值
 * 三个指针pre, cur, next 保证没有值被剩下，然后一直往下走
 *
 * M2：
 * ListNode curHead = reverseList(head.next); // 一直往上跑的一直是  最后一个list值
 * ! 跑到哪停很重要，是pre pre null 就停住, 所以才能使pre null反指 pre pre null
 * head.next.next = head = 反指
 *
   head.next.next = head; // 将 生成的反向 list 反指 node head
   head.next = null;      // 此时我的head 也不往下值了，我就指null, 作尾巴
 *
 *
 * 7/14/20.
 */
public class _206_reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;

        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {


        if(head == null || head.next == null){
            return head;
        }

        ListNode curHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return curHead;


    }
    public static void main(String[] args) {
        _206_reverse_linked_list solution = new _206_reverse_linked_list();
        ListNode.print(solution.reverseList2(ListNode.createTestData("[1,2,3]")));
    }
}
