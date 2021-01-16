package tree.recursion;

import utils.TreeNode;

/**
 *

 helper(node, level) level 其实没有实质作用，有用的是记录往那一行查

 一开始，用了level,多余了， 然后冗杂的变量也没处理好，  用 ||  || 更能剔除不满足题意的变量

M0: bottom up
 DFS- T:(N) S:O(h)

 其实更好理解 -
 return Math.max(left,right)+1; //来给我最终的height

M1: bottom up + top down

 想到可以1个node, 下面连没连子node，但不知道怎么往下走---- 递归的通用方法

 recursive T:O(N^2)  S:O(h)
 --------
 1. if node is good
 2. return isBalance(node.left, node.right)
 ---------

 01/16/20

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
    public boolean isBalanced0(TreeNode root) {
        // 什么时候需要记录level 值-  看他平不平衡
        // 这里可以用level 帮助判断
        if(root == null){
            return true;
        }
        return dfs(root) != -1 ;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        // must three check here
        if(left == -1 || right == -1 || Math.abs(left-right)>1){
            return -1;
        }
        // max will cover the case, no matter left == null || right || 我这层就会会运算上+1
        return Math.max(left,right)+1;
    }



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
