package dfs.tree;

import utils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 1.不但要输出nodelist, 原来的node也要剪枝的，
 * 所以dfs() 做了2件事
 * > 剪枝, 如果可以被砍，直接返回的是null
 *  node.left = dfs(node.left, list, set);
    node.right = dfs(node.right, list, set);
 * > 回加to the list
 *  if(set.contains(node.val)){
      if(node.left != null) list.add(node.left);
      if(node.right != null) list.add(node.right);
         return null;
    }

   2. 因为root 恒没有机会判断
   let's add it in the first parse
 *
 *
 *
 *
 *
 * 往下走，怎么才能走对，dfs是有效的么
 *
 * T:O(N) S:O(N+H) H as the tree
 *
 * 8/26/20.
 */
public class _1110_delete_nodes_and_return_forest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> list = new LinkedList<TreeNode>();
        if(root == null){
            return list;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for(int val: to_delete){
            set.add(val);
        }
        if(!set.contains(root.val)){
            list.add(root);
        }
        dfs(root,list,set);
        return list;
    }

    public TreeNode dfs(TreeNode node, List<TreeNode> list, HashSet<Integer> set){
        if(node == null){
            return null;
        }

        node.left = dfs(node.left, list, set);
        node.right = dfs(node.right, list, set);

        if(set.contains(node.val)){
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
            return null;
        }

        return node;
    }
}
