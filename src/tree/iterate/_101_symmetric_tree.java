package tree.iterate;

import utils.TreeNode;

import java.util.Stack;

/**
 *
 * M1: Recursive
 *
 * how to understand it complexity?
 *
 *  T:O(N) S:O(H)
 *
 * M2: Iterate - Stack
 * 判断这儿，得这样：
 *  if(node1== null && node2 == null) continue;
 *  if(node1 == null || node2 == null || node1.val != node2.val) return node1 == node2;
 *
 * Why M1 not need it?
 *  because stack always has other content, not only the pop one.
 *
 *
 * 7/20/20.
 */
public class _101_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1== null && node2 == null) continue;
            if(node1 == null || node2 == null || node1.val != node2.val) return node1 == node2;

            stack.push(node2.left);
            stack.push(node1.right);
            stack.push(node2.right);
            stack.push(node1.left);
        }
        return true;
    }
}
