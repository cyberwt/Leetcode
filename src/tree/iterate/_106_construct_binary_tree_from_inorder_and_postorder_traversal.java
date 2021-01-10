package tree.iterate;

import utils.TreeNode;

/**
 * 9.27
 * 想要对root进行什么操作，怎样操作，
 * 那我就不断在其中
 *
 *
 *
 *
 * -- 用一个hashmap, 扔进去，就不用每次都扫index了
 * iterate的时候注意，不是一直都直通答案
 *
 * 质疑在过程中，有把谁filter掉
 *
 * 7/23/20.
 */
public class _106_construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Corner Case
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        TreeNode node = build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return node;
    }

    public TreeNode build(int[] inorder, int inStart, int endStart, int[] postorder, int postStart, int postEnd){
        if(inStart>endStart || postStart>postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index =0;
        for(int i=inStart; i<=endStart; i++){
            if(inorder[i] == postorder[postEnd]){
                index = i;
                break;
            }
        }
        int len = index-inStart;
        root.left = build(inorder,inStart,index-1, postorder,postStart,postStart+len-1);
        root.right = build(inorder,index+1, endStart,postorder,postStart+len,postEnd-1);
        return root;
    }
}
