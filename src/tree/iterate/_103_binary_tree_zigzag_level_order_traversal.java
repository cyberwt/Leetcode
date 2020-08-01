package tree.iterate;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Same as level order 1. bfs 2. iterate
 * 7/22/20.
 */
public class _103_binary_tree_zigzag_level_order_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        bfs(root,res,0);
        return res;
    }

    public void bfs(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null){
            return;
        }
        if(res.size() <=level){
            res.add(new LinkedList<Integer>());
        }

        if(level % 2 == 0){
            res.get(level).add(node.val);
        }else{
            res.get(level).add(0,node.val);
        }

        bfs(node.left,res,level+1);
        bfs(node.right,res,level+1);
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null)
            return ans;
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // 当前层元素的个数
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    if ((level % 2) == 0) {
                        subList.add(curNode.val);
                    } else {
                        subList.add(0, curNode.val);
                    }
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            //因为上边 queue.offer(curNode.left) 没有判断是否是 null
            //所以要判断当前是否有元素
            if (subList.size() > 0) {
                ans.add(subList);
            }
            level++;
        }
        return ans;
    }
}
