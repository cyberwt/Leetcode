package microsoft;

/**
 * M1: Iterate
 * > 为什么没想到？
 * 不知道在哪停下，但用到了tem的思想，把可能的值记下来再说
 *
 * M2: Recursive
 * > 怎么下到我满意的值
 *
 * 9/10/20.
 */
public class _285_inorder_successor_in_BST {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int x){
            val = x;
        }

    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        TreeNode cur = root;
        if(cur == null) return res;
        while(cur != null){
            if(p.val < cur.val){
                res = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return res;
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }


    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
}
