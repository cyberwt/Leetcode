package tree.recursion;

import utils.TreeNode;

/**
 * Ms(root) := max path sum
 *  1. root must be used
 *  2. at most one child can be used
 *
 *  Which brings us the final anser
 *
 *
 * T:O(n)
 * S:O(h)
 *
 * 这道题很神奇的点在于，设置了一个全局变量，算此时的node 带不带上左右节点
 *
 * helper 是算单条路径的，
 * res 是算整个子树的 res = Math.max(res,max+left+right);
 *   max+ Math.max(left,right);
 * 7/31/20.
 */
public class _124_binary_tree_maximum_path_sum {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
}

    public int helper(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        int max = node.val;

        res = Math.max(res,max+left+right);


        return max+ Math.max(left,right);
    }

}
