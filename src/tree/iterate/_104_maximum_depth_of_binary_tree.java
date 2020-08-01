package tree.iterate;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * M1
 * 简单的dfs 向下搜索，代码可以更简洁！
 *
 * M2
 * 同理用bfs count++
 *
 * 7/22/20
 */
public class _104_maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int res = findDepth(root,1);
        return res;
    }

    public int findDepth(TreeNode node, int level){
        if(node == null){
            return level-1;
        }

        int left = findDepth(node.left, level+1);
        int right = findDepth(node.right, level +1);

        return Math.max(left, right);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
