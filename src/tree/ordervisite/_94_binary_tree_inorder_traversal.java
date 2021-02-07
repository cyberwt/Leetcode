package tree.ordervisite;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * cur先不进站，先忘里面放，当他此时是空时，弹出,加到list里，再找node.right
 *
 * 2/2/21
 */
public class _94_binary_tree_inorder_traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 这个解法，root 一开始是不进站的
        List<Integer> list = new LinkedList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!= null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }
}
