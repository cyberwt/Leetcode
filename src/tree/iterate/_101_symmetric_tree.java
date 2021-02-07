package tree.iterate;

import utils.TreeNode;

import java.util.Stack;

/**
 * recursive 时， 构建自函数，不是想当然就拿出 isTrue(node1.left, node1.right)
 * 而是构建新的结构: isTrue(node1.left, node2.right) && isTrue(node1.right, node2.left)
 *
 * how to understand it complexity? - 每个点我都会访问，且构造stack状态，不断弹压
 *
 *
 * 2/1/21
 *
 * 8.14
 *
 * 完全不记得，要两个两个去比，才是镜像的效果-- 所以 ！不是level order traversal,
 * 每次只弹出两个值
 * 看完题解， 要想清楚怎么 recursive & iterative 都生效
 *
 * M1: Recursive
 *
 * how to understand it complexity?
 *
 *  T:O(N) S:O(H)
 *
 * M2: Iterate - Stack
 * 判断这儿，得这样：
 *  if(node1== null && node2 == null) continue;
 *  if(node1 == null || node2 == null || node1.val != node2.val) return node1 == node2;
 *
 * Why M1 not need it?
 *  because stack always has other content, not only the pop one.
 *
 *
 * 7/20/20.
 */
public class _101_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isTrue(root.left, root.right);
    }

    public boolean isTrue(TreeNode node1, TreeNode node2){
        if(node1==null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return isTrue(node1.left, node2.right) && isTrue(node1.right, node2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1== null && node2 == null) continue;
            if(node1 == null || node2 == null || node1.val != node2.val) return node1 == node2;

            stack.push(node2.left);
            stack.push(node1.right);
            stack.push(node2.right);
            stack.push(node1.left);
        }
        return true;
    }
}
