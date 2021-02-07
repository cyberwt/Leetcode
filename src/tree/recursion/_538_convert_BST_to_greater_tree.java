package tree.recursion;

import utils.TreeNode;

import java.util.Stack;

/**
 * > M1 - r:
 *  辅助参数，记录所有右根的值，当我扫完所有右根是，我的左跟，只要继续往下走就行
 *
 * > M2:
 *  用stack不断 push 右面的值进去，然后加好，保留之后sum的值
 *
 * 2/2/21.
 */
public class _538_convert_BST_to_greater_tree {
    public TreeNode convertBST(TreeNode root) {
        // how to undersatnd since treenode value is alos changed
        //两种解法，都有意义recursive && iterative
        if(root == null) return root;
        dfs(root,0);
        return root;
    }

    public int dfs(TreeNode node, int sum){
        if(node == null) return sum;
        node.val += dfs(node.right,sum);
        return dfs(node.left, node.val);
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }
}
