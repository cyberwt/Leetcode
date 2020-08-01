package tree.recursion;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 所以代码上需要修正这个算法，再想想题目要求是从根节点到叶节点，
 * 所以如果有一个子树的左孩子或者右孩子为null了，
 * 那就意味着这个方向不可能到达叶子节点了，所以就不要再用Min函数去判断了。
 *
 *
 *
 *
 * 7/27/20.
 */
public class _111_minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return findDepth(root);
    }

    public int findDepth(TreeNode node){
        //到达叶子节点就返回 1
        if(node.left == null && node.right == null){
            return 1;
        }
        //左孩子为空，只考虑右孩子的方向
        if(node.left == null){
            return findDepth(node.right) +1;
        }
        //右孩子为空，只考虑左孩子的方向
        if(node.right == null){
            return findDepth(node.left) +1;
        }
        //既有左孩子又有右孩子，那么就选一个较小的
        return Math.min(findDepth(node.left), findDepth(node.right))+1;

    }

    public int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return 0;
        queue.offer(root);
        /**********修改的地方*****************/
        int level = 1;
        /***********************************/
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // 当前层元素的个数
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    /**********修改的地方*****************/
                    if (curNode.left == null && curNode.right == null) {
                        return level;
                    }
                    /***********************************/
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
