package tree.recursion;

import utils.TreeNode;

/**
 * 很巧妙的dfs,
 * 因为它包含了这个特点，要不然有两个值，要不然一个是空
 * 所以每次如果不想等了，就一定是第二大的值
 *
 * E:
 * > 必须有这个判断，否则会略过 -1 直接来了
 *   if(left == -1) return right;
     if(right == -1) return left;
 *
 *
 * 5/10/21.
 */
public class _671_second_minimum_node_in_a_binaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int val){
        if(node == null) return -1;
        if(node.val != val) return node.val;
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        if(left == -1) return right;
        if(right == -1) return left;
        return Math.min(left, right);
    }

}
