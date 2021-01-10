package list.merge;

import utils.ListNode;

/**
 *
 * LinkedList Merge:
 * 1) dummy node helps
 * 2) can't point null 值
 * 所以a.在while循环上判断 用& 更清晰 or b.在循环里不断判断
 *
 * T:O(N) S:O(1)
 *
 * 6/28/20.
 */
public class _21_merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode run = dummy;
        while(l1!= null && l2!=null){
            if(l1.val >= l2.val){
                run.next = l2;
                l2 = l2.next;
            }else if(l1.val < l2.val){
                run.next = l1;
                l1 = l1.next;
            }
            run = run.next;
        }
        if(l1!=null){
            run.next =l1;
        }

        if(l2!=null){
            run.next=l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        _21_merge_two_sorted_lists solution = new _21_merge_two_sorted_lists();
        ListNode.print(solution.mergeTwoLists(ListNode.createTestData("[1,2,3]"),
                ListNode.createTestData("[5,6,7]")      ));
    }


}
