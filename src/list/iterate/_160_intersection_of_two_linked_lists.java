package list.iterate;

import java.util.HashSet;
import java.util.Set;

/**
 * 3/16/21
 *
 * 1. m0 是基础 set store
 * 2. 理解 m1 的4种情况
 * 3. ListNode 怎么写
 *
 * traverse A, hash all the nodes
   traverse B, if a node in in the hash, return it as a intersection has been found
   return None if by the end of step 2, nothing returned



 * M0:
 * 正常解法 - set
 * 求长度差值，然后再一起走，终会相遇 == no, no , if I want =to find some common values,
 * how about I store it in hash set
 *
 * T: O(N+M) S:O(1)
 *
 * M1:
 * 巧妙解，做优化，一直走啊走，一定会相遇，因为走的路程是一样的
 *
 * a = a==null? headB:a.next
 *
 * 聪明
 * https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
 * 四种情况讨论，都在图上说明了
 * a.同长有交集
 * b.异常有交集(多走的点是差值，终相遇)
 * c.同长无交集
 * d.异常无交集 (a==b == null 时停了)
 *
 * 人家的图，画得清楚 ，在list上走时候，更清晰的判断
 * T: O(N+M) S:O(1)
 *
 * 8/15/20.   3/16/
 */
public class _160_intersection_of_two_linked_lists {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }


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


    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        Set nodeVisit = new HashSet<>();

        while ( headA != null ) {
            nodeVisit.add(headA);
            headA = headA.next;
        }

        while ( headB != null ) {
            if ( nodeVisit.contains(headB) ) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
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
