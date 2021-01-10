package tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 8.16
 * 又不会做了，是一个recursive找答案的过程
 *
 *
 * 二叉搜寻树的中序遍历是升序序列 -> 根据此性质，实现，遍历
 *
 * M1: Queue iteration
 *
 * T:O(N) S:O(h)
 *
 *
 * M2: Stack tracback
 *
 * T:O(N) S:O(h)
 *
 *
 * 7/2/20.
 */
public class _173_binary_search_tree_iterator {
    Queue<Integer> queue = new LinkedList<Integer>();
    public _173_binary_search_tree_iterator(TreeNode root) {
        inorderIterator(root);
    }

    public void inorderIterator(TreeNode root){
        if(root == null){
            return;
        }

        inorderIterator(root.left);
        queue.add(root.val);
        inorderIterator(root.right);

    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */