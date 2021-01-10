package list.merge;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 9/20
 * M1. Divide and Conquer
 * 典型divide conquer 结构
 * divide first, then merge
 *
 * Tips:
 * 想了下 是 start,mid,end 的关系，每次mid都是靠近start的，所以3种情况都符合
 * 0 1 2 || 1 2 || 1  -> start end 从123的各自关系
 *
 * ListNode node1 = merge(lists,left,mid);
   ListNode node2 = merge(lists,mid+1,right);
   return merge2List(node1,node2);
 *
 * M2: 理解priorityQueue
 * > Override new comparator
 * > queue.poll()出来的是一个list !!!
 * if(tai.next != null){
 *     queue.add(tail.next);
 * }
 * T:O(NlogN)
 *
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (right - left) / 2 + left;
        ListNode node1 = merge(lists, left, mid);
        ListNode node2 = merge(lists, mid + 1, right);
        return merge2List(node1, node2);

    }


    public ListNode merge2List(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            ListNode node;
            if (node1.val < node2.val) {
                node = node1;
                node1 = node1.next;
            } else {
                node = node2;
                node2 = node2.next;
            }
            cur.next = node;
            cur = node;
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        _23_merge_k_sorted_lists solution = new _23_merge_k_sorted_lists();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.createTestData("[5,6,7]");
        lists[1] = ListNode.createTestData("[1,2,7]");
        lists[2] = ListNode.createTestData("[6,2,7]");
        ListNode.print(solution.mergeKLists(lists));
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val < node2.val) {
                    return -1;
                } else if (node1.val == node2.val) {
                    return 0;
                } else {
                    return 2;
                }
            }
        });

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}