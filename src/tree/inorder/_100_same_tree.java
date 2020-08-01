package tree.inorder;

/**
 *
 * 遍历扔掉的条件
 *
 * 在什么情况，我return true:
 *  . 两者都指空
 *  . 遍历完所有序列
 *
 * 在什么情况下，
 *  . 要是有不等的时候 return false
 *  .
 */

public class _100_same_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorderTraversal(p,q);
    }

    public boolean inorderTraversal(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }


        if(p.val != q.val){
            return false;
        }

        if(!inorderTraversal(p.left,q.left)){
            return false;
        }

        if(!inorderTraversal(p.right, q.right)){
            return false;
        }

        return true;
    }
}
