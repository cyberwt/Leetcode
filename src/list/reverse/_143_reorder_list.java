package list.reverse;

import utils.ListNode;

import java.util.HashMap;

/**
 * M1: 正分接法
 * // 怎么将最后的值链接到数组前面，就需要reverse 然后intervine
 *
 * a/ Find the middle of the list
 * b/ Reverse the half after middle
 * c/ Start reorder one by one
 * ! Error: 为什么reorder 要单独写一个函数 -> 不会破坏head的取值（头指针不会变）
 *
 * M2: 平移数据结构，换成 HashMap 存取
 *
 *
 * !Error: j = map.size()-1
 *
 *
 * 8/9/20.
 */
public class _143_reorder_list {
    public void reorderList(ListNode head) {
        // 3 steps
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        // intervaine

        merge(head, head2);

        return;
    }

    public ListNode reverse(ListNode node){
        ListNode pre = null, cur =node;
        while(cur!=null){
            ListNode tem = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tem;
        }
        return pre;
    }

    private void merge(ListNode head1, ListNode head2) {
        while (head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }

    public void reorderList2(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        HashMap<Integer,ListNode> map = new HashMap<Integer,ListNode>();
        int index =0;
        ListNode cur =head;
        while(cur != null){
            map.put(index,cur);
            cur = cur.next;
            index++;
        }
        int j= map.size()-1, i=0;
        while(i<j){

            map.get(i).next = map.get(j);
            i++;
            map.get(j).next = map.get(i);
            j--;
        }
        map.get(i).next = null;

    }
}
