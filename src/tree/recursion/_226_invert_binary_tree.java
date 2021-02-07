package tree.recursion;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 * 3种解法重新理解: invertTree 返回的恒是head, 但实际做的事左右子树交换
 *
 * 1/31/21
 *
 *  M1: Single recursive, not scalable
 *  M2: Stack, help --  同 iterate every node, 达到换子node的目的
 *  M3: Queue, help -- 每一个node的子node, 位置都变了，所以level order, itervate 帮助每一个子node换位置
 *
 *  √ 重新理解，为什么 queue & stack 在这里是通用的
 *  1/16/21
 *
 *
 *
 * 看清要对根结点做什么操作，然后
 *
 * 在下到每一层，是不是左右子树也需要同样的操作
 *
 *
 * 9/26/20.
 */
public class _226_invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);
        return root;
    }
     // scalable - avoid apploication stack overflow
    // >>> more robust solution would be to use stack data structure.
    // >>> and  the ease of logging/debugging.
    public TreeNode invertTree2(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    //same as bfs to use queue
    //
    public TreeNode invertTree3(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
