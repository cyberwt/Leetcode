package tree.ordervisite;

import utils.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * M1: iterative
 *
 * Error: 弹出的时候，先判断是否是 null,就直接 continue
 *
 *
 *
 * M2: recursive
 * 左右跟
 *
 * 2/1/21.
 */
public class _145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        // how can I play with stack?
        while(!stack.isEmpty()){
            int size = stack.size();
            for(int i=0; i<size; i++){
                TreeNode node = stack.pop();
                if(node == null) continue;
                list.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        //左右根
        List<Integer> res = new LinkedList<Integer>();
        if(root == null){
            return res;
        }

        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode node){
        if(node == null){
            return;
        }

        helper(res, node.left);
        helper(res, node.right);
        res.add(node.val);
        return;
    }
}
