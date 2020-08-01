package tree.recursion;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 还是用该按照 通解，
 * 左或右 是空么， 不空的话正常来呗。
 *
 * backTracking 基本远离:
 *
 * add
 * backtrack
 * remove
 *
 * 7/27/20.
 */
public class _113_path_sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //backtracking!
        List<List<Integer>> res = new LinkedList<>();

        if(root == null) {
            return res;
        }

        findSum(root,res,sum, new LinkedList<Integer>());
        return res;
    }

    public void findSum(TreeNode node, List<List<Integer>> res, int sum, LinkedList<Integer> list){
        if(node.left == null && node.right == null){
            if(sum == node.val){
                list.add(node.val);
                res.add(new LinkedList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }

        if(node.left == null){
            list.add(node.val);
            findSum(node.right, res, sum-node.val, list);
            list.remove(list.size()-1);
            return;
        }

        if(node.right == null){
            list.add(node.val);
            findSum(node.left, res, sum-node.val, list);
            list.remove(list.size()-1);
            return ;
        }

        list.add(node.val);
        findSum(node.left, res, sum-node.val, list);
        list.remove(list.size()-1);

        list.add(node.val);
        findSum(node.right, res, sum-node.val, list);
        list.remove(list.size()-1);

    }
}
