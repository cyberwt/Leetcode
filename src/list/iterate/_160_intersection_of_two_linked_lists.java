package list.iterate;

import utils.ListNode;

/**
 * 9/20
 * 正常解法
 * 求长度差值，然后再一起走，终会相遇
 * M2:
 * 巧妙解，做优化，一直走啊走，一定会相遇，因为走的路程是一样的
 *
 * a = a==null? headB:a.next
 *
 * 聪明
 *
 * 四种情况讨论，都在图上说明了
 * a.同长有交集
 * b.异常有交集(多走的点是差值，终相遇)
 * c.同长无交集
 * d.异常无交集 (a==b == null 时停了)
 *
 * 人家的图，画得清楚 ，在list上走时候，更清晰的判断
 * 8/15/20.
 */
public class _160_intersection_of_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = a == null? headB :a.next;
            b = b == null? headA :b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        int diff = Math.abs(sizeA-sizeB);
        ListNode curA= headA;
        ListNode curB = headB;

        if(sizeB>sizeA){
            while(diff>0){
                curB = curB.next;
                diff--;
            }
        }

        if(sizeB<sizeA){
            while(diff>0){
                curA = curA.next;
                diff--;
            }
        }

        while(curA!=curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    public int getSize(ListNode node){
        int len=0;
        while(node!=null){
            node=node.next;
            len++;
        }
        return len;
    }
}
