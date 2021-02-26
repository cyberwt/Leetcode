package tree.recursion;

import utils.TreeNode;

import java.util.Stack;

/**
 *
 * M1:
 * 知道是recursive
 * 1.应该保留的是上面的root值，而不是下面那层的值，小小全小，大大全大
 * 2.用null 取代 (Integer.MAX_VALUE) -> 只有一个node时 [2147483647]
 * 3.有一半比较时，没有再用，没关系 -- node replace
 *
 * 2/8 很巧妙的null 被cur node 替换掉
 *
 * M2: Inorder - stack
 * 1. 不理解为什么成立的是这个条件，且最后return true;
 * > 前面成立，后面在走向下一个loop 时一定会成立
 * >> while(root != null || stack.isEmpty()) - 为了和 下面的 适配起来，
 *   while(root!=null){
         stack.push(root);
         root = root.left;
     }
  最重要的是 我是一个inorder traverse, 只有左 -> 中 -> 右 这一条路， 待到中间再pop
 *
 * 9/21/20.
 */
public class _98_validate_binary_search_tree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isValid(root, null,null);
    }

    public boolean isValid(TreeNode node, Integer min, Integer max){
        if(node == null){
            return true;
        }

        if((min!=null && node.val<=min) || (max!=null && node.val>=max)){
            return false;
        }

        return isValid(node.left, min, node.val) && isValid(node.right, node.val,max);

    }


    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // why two condition is and or or
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            // 为什么是|| 因为1成立，2也就会成立
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
