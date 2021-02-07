package backtracking.tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * >1. dfs的跳出条件
 * if(node.left == null && node.right == null){
     res.add(str + node.val);
   }
 *  不要僵化
 * > 2. string & string builder为什么出现了不同
 * 限制了stringBuilder的长度
 * When using StringBuilder, We can just keep track of the length of the StringBuilder
 * before we append anything to it
 * before recursion and afterwards set the length back.
 * Another trick is when to append the "->",
 * since we don't need the last arrow at the end of the string, we only append it before recurse to the next level of the tree. Hope the solution helps!
 *
 *
 * sb.setLength(len);
 *
 * T:O(N） S:(1)
 *
 * 1/23/21.
 */
public class _257_Binary_tree_paths {
    public List<String> binaryTreePaths(TreeNode root) {
        // how about your sense to the dfs problem
        List<String> res = new LinkedList<String>();
        if(root != null) {
            dfs(root, res,"");
        }
        return res;
    }

    public void dfs(TreeNode node, List<String> res, String str){
        // 跳出条件为什么写在上面，不是下面
        // 不是判断  -- 1.26 如果没有 '->'，直接往下走没关系，但这个有了 -> ,他提前确保了这个值非空
        if(node.left == null && node.right == null){
            res.add(str + node.val);
        }
        // don't understand why there's backtrack
        // how to understand string is immutable
        if(node.left != null) dfs(node.left,res,str+ node.val + "->" );
        if(node.right != null) dfs(node.right,res, str+node.val+"->");


    }
}
