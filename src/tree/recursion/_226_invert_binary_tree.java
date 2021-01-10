package tree.recursion;

import utils.TreeNode;

/**
 * 看清要对根结点做什么操作，然后
 *
 * 在下到每一层，是不是左右子树也需要同样的操作
 *
 *
 * 9/26/20.
 */
public class _226_invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
