package tree.recursion;

import utils.TreeNode;

/**
 *
 *  //因为是不规则树，不一定哪条分支是最长
 *
 *  而路径这里指的是，树枝长(不包括主node的其他node总数)
 *
 *  而getDepth指我这个分支有多长
 *
 * 1/31/21.
 */
public class _543_diameter_of_binary_tree {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        getDepth(root);
        return max;
    }

    public int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        max = Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
