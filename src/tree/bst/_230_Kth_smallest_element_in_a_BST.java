package tree.bst;

import utils.TreeNode;

import java.util.Stack;

/**
 * bst 和 tree iterative 的结合
 *
 * m1: stack iterative
 *
 * m2: recursion
 *
 * 2/2/21.
 */
public class _230_Kth_smallest_element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null | k<=0) return -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!= null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;

        }
        return -1;
    }

    private int cnt = 0;
    private int val;

    public int kthSmallest2(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}
