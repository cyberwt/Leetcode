package tree.recursion;

import utils.TreeNode;

/**
 * 很巧妙的间隔 取值，
 * 要不然就去本层和下下层 或 下层去取
 *
 *
 * 2/1/21.
 */
public class _337_house_robber_III {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val = root.val;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val, val2);
    }
}
