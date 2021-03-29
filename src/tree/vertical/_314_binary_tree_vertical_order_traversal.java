package tree.vertical;

import utils.TreeNode;

import java.util.*;

/**
 *
 *  > DFS 大体思路对了，但dfs 直接求会出现越界
 *
 *  DFS in-order won't work because it violates the order restriction of top-to-bottom. As you can see the failing test case, 8 is on the right side hence reached later than 2 always. But 8 is above 2, meaning that 8 should come before 2.
 *
 *
 * dfs process depth first, if some left leaves already been process, right node won't been prcoess in order
 *
 * so use Map<Integer, Map<Integer, List<Integer>>> map to contrains the dfs search
 *
 *  > BFS O(N)
 *
 *  clever as use a queue  +
 *  2 Map
 *  map<TreeNode, column>  + map<column, list>
 *
 *
 * Created by weitong on 3/27/21.
 */
public class _314_binary_tree_vertical_order_traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        helper(root, map, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int col : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            for (int row : map.get(col).keySet()) {
                list.addAll(map.get(col).get(row));
            }
            res.add(list);
        }
        return res;
    }

    private void helper(TreeNode node, Map<Integer, Map<Integer, List<Integer>>> map, int col, int row) {
        if (node == null) return;
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new ArrayList<>());
        map.get(col).get(row).add(node.val);
        helper(node.left, map, col - 1, row + 1);
        helper(node.right, map, col + 1, row + 1);
    }


    // BFS
    public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        //use a HashMap to store the TreeNode and the according cloumn value
        Map<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        weight.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            //update min ,min means the minimum column value, which is the left most node
            min = Math.min(min, w);
        }
        while (map.containsKey(min)) {
            res.add(map.get(min++));
        }
        return res;
    }
}
