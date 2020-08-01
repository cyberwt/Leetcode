package tree.recursion;

import utils.TreeNode;

/**
 M1:
 一开始没想明白，到底返回的是高度，还是boolean值
* 返高度的话，求的一直都是子树最高，没意义
* 返boolean的话，没有参数结合起来判断
--> 结果是返回 int,然后每层判断，

 M2:
 就会少很多重复的步骤

 只要我的小子树有任意一个值没有意义，
 那就返回 -1 吧


 7/24/20.
 */
public class _110_balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int left = find(root.left);
        int right = find(root.right);

        if(Math.abs(left-right) >1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int find(TreeNode node){
        if(node == null) return 0;

        int left = find(node.left);
        int right = find(node.right);
        return Math.max(left,right)+1;

    }

    public boolean isBalanced2(TreeNode root) {
        return checkTree(root) != -1;
    }

    public int checkTree(TreeNode node){
        if(node == null) return 0;

        int leftTree = checkTree(node.left);
        if(leftTree == -1){
            return -1;
        }

        int rightTree = checkTree(node.right);
        if(rightTree == -1){
            return -1;
        }

        if(Math.abs(leftTree-rightTree) > 1){
            return -1;
        }

        return Math.max(leftTree, rightTree)+1;

    }
}
