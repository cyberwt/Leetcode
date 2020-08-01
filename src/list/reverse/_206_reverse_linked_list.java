package list.reverse;

import utils.ListNode;

/**
 * M1:
 * next 为预留值
 * 三个指针pre, cur, next 保证没有值被剩下，然后一直往下走
 *
 * M2：
 * ListNode curHead = reverseList(head.next); // 一直往上跑的一直是  最后一个list值
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
