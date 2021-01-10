package tree.recursion;

import utils.TreeNode;

import java.util.Stack;

/**
 * 9.26
 * M1: 我就要flat 我这个node, flat左,然后flat右，然后左右连到一起去，左清空,右继续慢慢移
 *
 *
 * M2: 我一个一个node,把我当前的关系处理好，移到右面去
 *
 *
 * 怎么理解他扁平化的过程-不断向右推的过程
 * 1. 退出条件
 * 2. 不断向外递归
 * 3. -左子树不为空
 *    -左子树向右移动
 *    -原来右子树接到左子树的最下方
 * *
 * 7/28/20.
 *
 *
 * M1: 递归
 *
 * M2: 迭代
 *
 * M3: 特殊的 pre-order
 */
public class _114_flatten_binary_tree_to_linked_list {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if(root.left != null){
            TreeNode rightNode = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode leftLastNode = root;
            while(leftLastNode.right != null){
                leftLastNode = leftLastNode.right;
            }
            leftLastNode.right = rightNode;
        }
    }

    public void flatten2(TreeNode root) {
        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;

                while(pre.right != null){
                    pre = pre.right;
                }

                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;

            }
        }
    }


    public void flatten3(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current_node = stack.pop();
            if(current_node.right != null){
                stack.push(current_node.right);
            }

            if(current_node.left != null){
                stack.push(current_node.left);
            }

            if(!stack.isEmpty()){
                current_node.right = stack.peek();
            }

            current_node.left = null;

        }

    }
}
