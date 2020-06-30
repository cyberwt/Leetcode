package list.merge;

import utils.ListNode;

/**
 *
 * M1: 直接套用mergeTwoMergeLists
 *
 * T:O(KN) S:O(1)
 *
 *
 * M2: 二分 不断 mergeTwoMergeLists
 * 时间复杂度：假设每个链表的长度都是 n ，有 k 个链表，记总结点数是 N = n * k，T=O(Nlogk) S:O(1)
 ​​*
 *
 * 6/28/20.
 */
public class _23_merge_k_sorted_lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        }
        return ans.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            System.out.println(lists.length);
            for (int i = 0; i + interval< lists.length; i=i+interval*2) {
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }

        return lists[0];
    }

    public static void main(String[] args) {
        _23_merge_k_sorted_lists solution = new _23_merge_k_sorted_lists();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.createTestData("[5,6,7]");
        lists[1] = ListNode.createTestData("[1,2,7]");
        lists[2] = ListNode.createTestData("[6,2,7]");
        ListNode.print(solution.mergeKLists(lists));
    }
}
