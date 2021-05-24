package dfs.graph;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 树高的定义:
 *  level: means the longest depth of curent node and the leaf node
 *
 * dfs-> 同高的树，加入相同的level res
 *
 * DFS : T:O(N) S:T:O(logn)
 * 5/14/21.
 */
public class _366_find_leaves_of_binary_tree {
    // 我要怎么整层move掉呢-> 把其转换成当前的此node的树高，如果满足在同层，
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        findNodeLevel(root, res);
        //
        return res;
    }

    //
    public int findNodeLevel(TreeNode node, List<List<Integer>> res){
        if(node == null){
            return -1;
        }
        // level: means the longest depth of curent node and the leaf node
        // 所以leaf node 距离是0， 空node 是-1
        int left = findNodeLevel(node.left, res)+1;
        int right = findNodeLevel(node.right, res)+1;
        int level = Math.max(left, right);
        //
        // 这里match 不上哎, 因为level 要和 res的结果match 上
        if(res.size() < level+1){
            res.add(new LinkedList<>());
        }
        res.get(level).add(node.val);
        return level;
    }

}
