package tree.ordervisite;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * M1:
 *  // 一开始不理解，为什么要先加右子树，是stack啊，先弹出来的是左子树
 *  // 而且，和bfs 理解弄混了，不用按层限定的弹出
 *
 * M2:
 *  递归
 *  // 一位要返回list, 但其实是错的，list作为object
 *   已经在移动的过程中被改动，不需要赋新值帮助
 *
 * 8/9/20.
 */
public class _144_binary_tree_preorder_traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
                System.out.println(node.right.val);
            }
            if(node.left != null) {
                stack.push(node.left);
                System.out.println(node.left.val);
            }
        }

        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }

        inorder(list,root);
        return list;
    }

    public void inorder(List<Integer> list, TreeNode node){
        if(node == null) return;
        list.add(node.val);
        inorder(list,node.left);
        inorder(list,node.right);
    }
}
