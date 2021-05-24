package tree.recursion;

import utils.TreeNode;

/**
 *
 * 怎样设置这个recursive保证全loop到
 *
 * 4/4
 * 典型的递归: 得到不同的node.left, node.right
 *
 * 1/31/21.
 */
public class _617_merge_two_binary_trees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode node = new TreeNode(t1.val+t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

}
