package tree.recursion;

import utils.TreeNode;

/**
 *
 * 
 * Created by weitong on 2/2/21.
 */
public class _236_lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;

    }
}
