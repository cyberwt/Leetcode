package tree.bst;

import utils.TreeNode;

/**
 * Get it
 *
 * E1:
 * > res is a double, but resturn is a int  => transfer its type
 *
 * > optimize a operation instead of just if else
 *
 * T:O(lg N) S:O(1)
 *
 *
 *
 * 2/27/21.
 */
public class _270_closest_binary_search_tree_value {
    public int closestValue(TreeNode root, double target) {
        if(root == null){
            return -1;
        }
        double res =root.val;
        TreeNode cur = root;
        while(cur != null){
            res = Math.abs(cur.val - target) <  Math.abs(res - target)
                    ? cur.val: res;
            cur = cur.val < target ? cur.right: cur.left;
        }
        return (int)res;
    }
}
