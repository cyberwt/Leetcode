package tree.iterate;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 以为dfs不行，但只要能get level & iterate all the nodes, it will work
 * ! if iterate all the nodes as the final purpose, both bfs & dfs can work-- how tp verift
 * ~???????
 *
 * BFS Error:
 * T:O(N) S:O()
 * > avoid defects
 * forget add root before iterate the queue
 * > optimize
 * 1.queue implements as linkedlist
 * 2.initial list, if size != 0, add to result
 *
 * DFS 没错
 *
 * 1/16/21
 *
 * M1:
 * - dfs 一层一层向里加
 * dfs(res, node.left, level+1);
 *
 * M2:
 * - 确定是用queue 还是stack   queue.offer  && queue.poll
 * - 定好number 后
 * while + for 向里前进
 * - 再判断一个额外条件:
 * if(list.size()!=0){
      res.add(list);
   }
 *
 *
 * 7/20/20.
 */
public class _102_binary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        dfs(res, root,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, TreeNode node, int level){
        if(node == null) return ;
        if(res.size() <= level){
            res.add(new LinkedList<Integer>());
        }

        res.get(level).add(node.val);

        dfs(res, node.left, level+1);
        dfs(res, node.right, level+1);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    list.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(list.size()!=0){
                res.add(list);
            }
        }
        return res;
    }


}
