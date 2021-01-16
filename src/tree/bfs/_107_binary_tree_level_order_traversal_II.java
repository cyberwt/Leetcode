package tree.bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * // 反向加，注意限制条件
 * list.add(0,new LinkedList<Integer>());
 * res.get(res.size()-1-level).add(node.val)
 *
 * T:O(N) S:O(N)
 * 1/15/21.
 */
public class _107_binary_tree_level_order_traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        bfs(res,root,0);
        return res;
    }

    public void bfs(List<List<Integer>> res, TreeNode root, int level){
        if(root == null) return;

        if(res.size() <= level){
            res.add(0,new LinkedList<Integer>());
        }

        res.get(res.size() -1-level).add(root.val);

        bfs(res, root.left, level+1);
        bfs(res, root.right, level+1);

    }


}
