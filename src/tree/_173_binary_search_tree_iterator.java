package tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 *


 Error：
 m1
 Construct: T:O(N) Else: O(1)
 1. inorder: 左中右
 2. Queue<Integer>, don't need to record node message
 m2:
 Construct: T:O(lgN)
 1.stack 只存node.left 进入stack
 2. stack<TreeNode>, need the TreeNode info

 3/22/21

 *
 *
 * 两种情况:
 * >queue 的方式 inorder traverse - complexity T:O(N) S:O(h) ⇒ tree height ⇒fact check

   T:O(N) S:O(h), hasNext() in O(1) time,  next() is O(1) time.

   >stack

   T:O(H) S:O(H), hasNext() in O(1) time,  next() is O(h) time.

  构建整个tree 和 next() function 的trade off
 *
 *
 * 2/25/21
 *
 *
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

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}