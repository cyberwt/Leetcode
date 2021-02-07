package tree.recursion;

import utils.TreeNode;

/**
 * getSum 是 得到该点 从该点到下面子叶点 的最经常出现个数
 *
 *
 * 2/1/21.
 */
public class _687_longest_univalue_path {
    int res =0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        getSum(root);
        return res;
    }

    public int getSum(TreeNode root){
        if(root == null){return 0;}
        int left = getSum(root.left);
        int right = getSum(root.right);
        int leftPath = root.left != null && root.val == root.left.val ? left+1 :0;
        int rightPath = root.right != null && root.val == root.right.val ? right+1 :0;
        res = Math.max(res, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
