package tree;


import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * M1: Iterate 每left, right 不断向下
 *
 * T:O(N) 遍历每个节点
 * S:O(1) 压栈消耗，h 是二叉树的高度
 *
 * 7/1/20.
 */
public class _94_binary_tree_inorder_traversal {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        bfs(root, res);
        return res;
    }

    public void bfs(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        bfs(node.left, res);
        res.add(node.val);
        bfs(node.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        // how can I make sure the stack is not empty at first

        TreeNode cur = root;
        while(cur!= null || !stack.isEmpty()){

            while(cur!= null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _94_binary_tree_inorder_traversal result =  new _94_binary_tree_inorder_traversal();
        TreeNode root = TreeNode.buildBinaryTree();
        System.out.println(result.inorderTraversal1(root));
        char aa = 'a';
        System.out.println(aa);
    }
}
