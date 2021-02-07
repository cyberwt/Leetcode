package tree.recursion;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 又忘了,let's look back this week
 *
 * BFS fits more better in this situation because:  而且同时规避了 node.left = null but node.right not
 * if (curNode.left == null && curNode.right == null) {
      return level;
    }
 * With BFS, instead of traversing 501 nodes to figure out the min depth,
 * you could've just traversed two. Now imagine if the left subtree comprised of tens of thousands of nodes ...
 *
 * recursive另一个参数，根本没用上, 因为level 是作为返回值的, 所以不需要穿进去，调用自身就可以了
 *
 * 2/1/21
 *
 * E:
 * > 同样的错误，single line format tree which only has one path
 * [2,null,3,null,4,null,5,null,6]
 * -----> 找到 root 的解释，single node can't be returned as result
 *  * Key point:
 * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
 * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
 *
 * > bfs is much better to save the unbalance tree which has a long path on one side, another path is extreme short
 *
 *
 * 1/16/21
 *
 * 所以代码上需要修正这个算法，再想想题目要求是从根节点到叶节点，
 * 所以如果有一个子树的左孩子或者右孩子为null了，
 * 那就意味着这个方向不可能到达叶子节点了，所以就不要再用Min函数去判断了。
 * 7/27/20.
 */
public class _111_minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        else {
            return Math.min(left, right) + 1;
        }
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
