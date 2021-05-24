package tree.bst;

import utils.TreeNode;

/**
 *
 * dfs出的值->是最近的第一个返回值
 * 必须是，第一个返回的值，which 从上到下最小的loop, 不必再往左走， 变小不符合题意， 这个点 无论如何不能再动了，无论上推或下推
 *
 *
 * 5/17/21
 *
 * bst的含义，左右中，一定会取 在树的哪一端，
 *
 * return -> 含义，让他返回
 *
 * !! res 恒存在于 p, q 之间，的唯一解
 *
 * Recursive
 *
 *
 *  > Iterative:为什么没有判断 root == null:
 * 如果p,q 一定在tree里，那root就一定存在
 *
 *
 * 9/24/20.
 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // how to deal when root is null
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // how to deal when root is null

        while(true){
            if(root.val > Math.max(p.val, q.val)){
                root = root.left;
            }else if(root.val < Math.min(p.val, q.val)){
                root = root.right;
            }else{
                return root;
            }
        }
    }
}
