package dfs;

import utils.TreeNode;

/**
 *完全自己做出来，但有个问题
 *
 * 一开始退出条件没想好
 * if(node == null) 退的话， 会有两个重复值，我要在node没有子节点 前就结束循环，省着多加 或 漏加
 *
 * 其实样列给的代码，会更清晰，不用你再写一个list, 一个全局变量就够了
 *
 * 同样，要更理解 回溯和分治的含义
 *
 * 7/31/20.
 */
public class _129_sum_root_to_leaf_numbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return sum;
    }

    int sum = 0;

    private void dfs(TreeNode root, int cursum) {
        //到达叶子节点
        if (root.left == null && root.right == null) {
            sum += cursum;
            return;
        }
        //尝试左子树
        if(root.left!=null){
            dfs(root.left,  cursum * 10 + root.left.val);
        }
        //尝试右子树
        if(root.right!=null){
            dfs(root.right, cursum * 10 + root.right.val);

        }

    }

    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int sum) {
        //已经累计的和
        int cursum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return cursum;
        }
        int ans = 0;
        //从最开始经过当前 root 再经过左孩子到达叶子节点所有的路径和
        if (root.left != null) {
            ans += sumNumbersHelper(root.left, cursum);
        }
        //从最开始经过当前 root 再经过右孩子到达叶子节点所有的路径和
        if (root.right != null) {
            ans += sumNumbersHelper(root.right, cursum);
        }
        //返回从最开始经过当前 root 然后到达叶子节点所有的路径和
        return ans;
    }
}
