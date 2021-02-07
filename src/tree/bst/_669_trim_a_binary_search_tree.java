package tree.bst;

import utils.TreeNode;

/**
 *
 * 什么时候构建辅助函数，什么时候，只要调用本身就足够.
 * > 看主函数的返回值类型，是否能够帮助解题
   > bst 的 左中右, 值的分配，要想清楚
   > 而recursive 的本质，就是让你，一键到底, 递归栈底只有一个node会返回
 *
 *  2/2/21.
 */
public class _669_trim_a_binary_search_tree {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if(root == null) return root;
        // 半个树直接抛掉
        if(root.val > high) return trimBST(root.left, low, high);
        if(root.val < low) return trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
