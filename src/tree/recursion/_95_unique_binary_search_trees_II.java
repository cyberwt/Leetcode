package tree.recursion;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * M1: recursion
 * - 因为 node 的值用 n 就可以代表
 * - 所以不断往下走，就可以分别得到 leftNode, rightNode
 *
 * M2:
 *
 * 7/16/20.
 */
public class _95_unique_binary_search_trees_II {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> tree = new LinkedList<TreeNode>();
        if(n == 0){
            return tree;
        }
        return get(1,n);
    }

    public List<TreeNode> get(int start, int end){
        List<TreeNode> tree = new LinkedList<TreeNode>();
        if(start > end){
            tree.add(null);
            return tree;
        }

        if(start ==end){
            tree.add(new TreeNode(start));
            return tree;
        }


        for(int i=start; i<=end; i++){
            List<TreeNode> leftTree = get(start,i-1);
            List<TreeNode> rightTree = get(i+1,end);
            for(TreeNode left: leftTree){
                for(TreeNode right: rightTree){
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    tree.add(cur);
                }
            }
        }
        return tree;
    }
}
