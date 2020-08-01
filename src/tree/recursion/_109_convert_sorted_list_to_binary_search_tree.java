package tree.recursion;

import utils.ListNode;
import utils.TreeNode;

/**
 * >快慢指针的判断条件: while(fast != tail && fast.next != tail)
 *
 * >直接往下走，每次重构
 *
 * 7/24/20.
 */
public class _109_convert_sorted_list_to_binary_search_tree {
    public TreeNode sortedListToBST(ListNode head) {

        return bst(head, null);
    }

    public TreeNode bst(ListNode head, ListNode tail){
        if(head == tail) return null;

        ListNode fast = head;
        ListNode slow = head;
        // do I need two check here? or one is enough
        while(fast != tail && fast.next!= tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = bst(head,slow);
        node.right = bst(slow.next, tail);
        return node;
    }
}
