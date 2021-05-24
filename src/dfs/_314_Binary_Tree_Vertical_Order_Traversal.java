package dfs;

import java.util.*;

/**
 *
 * 由于后面要跌伤，所以必须设置一个变量记录先后顺序
 *
 * BFS:
 * Map<Integer, ArrayList<Integer>> map (weight, list)
 * Map<TreeNode, Integer> (treenode, weight)
 *
 * 4/11/21.
 */
public class _314_Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // must be a dfs to get the same horizental value
        // I need a special list to help me manage the
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        dfs(root, map, 0);
        for(int key: map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
    // how can I send it by its order
    public void dfs(TreeNode node, TreeMap<Integer, List<Integer>> map, int level){
        if(node == null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level, new LinkedList<>());
        }
        map.get(level).add(node.val);
        dfs(node.left,map, level-1);

        dfs(node.right,map, level+1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
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

