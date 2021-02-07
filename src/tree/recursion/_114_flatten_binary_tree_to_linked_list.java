package tree.recursion;

import utils.TreeNode;

import java.util.Stack;

/**
 * M1:
 * 理解这个后序遍历的过程，先丢进去，从最底部flat,
 * 那flat 这个过程:
 * left 贴到right位置
 * 那right 怎么办？left'(cur right)不断向下，找到那个适合放pre right的位置
 *
 * M3:
 * 每一个点我们都在 stack 里 iterate 一遍
 * 每一次是 pop 新值，下一步是用的 peek()
 *
 *
 *
 * 2.7/21
 *
 *
 *
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

        //是一个后序遍历么
        // 左右中
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while(root.right!=null){
            root = root.right;
        }
        root.right = right;
        return;
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
