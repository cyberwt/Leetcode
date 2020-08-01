package tree.recursion;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 构建一个清晰的 Iterative & recursive
 *
 *
 * 想清楚为什么发生
 *
 * 7/27/20.
 */
public class _112_path_sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, sum);
    }

    private boolean hasPathSumHelper(TreeNode root, int sum) {
        //到达叶子节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        //左孩子为 null
        if (root.left == null) {
            return hasPathSumHelper(root.right, sum - root.val);
        }
        //右孩子为 null
        if (root.right == null) {
            return hasPathSumHelper(root.left, sum - root.val);
        }
        return hasPathSumHelper(root.left, sum - root.val) || hasPathSumHelper(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        if (root == null)
            return false;
        queue.offer(root);
        queueSum.offer(root.val);
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // 当前层元素的个数
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                int curSum = queueSum.poll();
                if (curNode != null) {
                    //判断叶子节点是否满足了条件
                    if (curNode.left == null && curNode.right == null && curSum == sum) {
                        return true;
                    }
                    //当前节点和累计的和加入队列
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                        queueSum.offer(curSum + curNode.left.val);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                        queueSum.offer(curSum + curNode.right.val);
                    }
                }
            }
        }
        return false;
    }
}
