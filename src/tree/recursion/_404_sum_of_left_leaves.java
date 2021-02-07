package tree.recursion;

import utils.TreeNode;

import java.util.Stack;

/**
 * 怎么判断是left nodes，它用了isLeaf 然后就说好了我遇见leftNode了，
 * 其他可以停一下，我要在potential right node上做继续观察了
 *
 * Recursive method.
 * For given node we check whether its left child is a leaf.
 * If it is the case, we add its value to answer, otherwise recursively call method on left child.
 * For right child we call method only if it has at least one nonnull child.
 *
 * Iterative method.
 * Here for each node in the tree we check whether its left child is a leaf.
 * If it is true, we add its value to answer, otherwise add left child to the stack to process it later.
 * For right child we add it to stack only if it is not a leaf.
 *
 *
 *
 * 2/1/21.
 */
public class _404_sum_of_left_leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(isLeaf(root.left)){
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    // how to determine it's a leave or not
    public boolean isLeaf(TreeNode node){
        if(node == null) return false;
        return node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
