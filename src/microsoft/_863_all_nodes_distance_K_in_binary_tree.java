package microsoft;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用dfs,以value node为界线， 先扫一遍，放入map,再看有没有这个key
 *
 * 9/10/20.
 */
public class _863_all_nodes_distance_K_in_binary_tree {
    Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        search(root, 0, K, res);
        return res;
    }

    private void find(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }

        if (root == target) {
            map.put(root, 0);
            return;
        }

        find(root.left, target);
        if (map.containsKey(root.left)) {
            map.put(root, map.get(root.left) + 1);
            return;
        }

        find(root.right, target);
        if (map.containsKey(root.right)) {
            map.put(root, map.get(root.right) + 1);
            return;
        }
        return;
    }

    public void search(TreeNode root, int dis, int K, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (map.containsKey(root)) {
            dis = map.get(root);
        }

        if (dis == K) {
            res.add(root.val);
        }

        search(root.left, dis + 1, K, res);
        search(root.right, dis + 1, K, res);
    }
}
