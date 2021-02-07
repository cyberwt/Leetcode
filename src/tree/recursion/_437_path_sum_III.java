package tree.recursion;

import utils.TreeNode;

/**
 *
 *
 *
 * 1/31/21.
 */
public class _437_path_sum_III {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int res = pathSum(root.left, sum) + pathSum(root.right, sum) + pathFromRoot(root,sum);
        return res;
    }

    public int pathFromRoot(TreeNode root, int sum){
        // 乱写
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.val == sum){
            res++;
        }
        res += pathFromRoot(root.left, sum-root.val) + pathFromRoot(root.right, sum-root.val);
        return res;
    }
}
