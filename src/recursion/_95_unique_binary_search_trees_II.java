package recursion;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *两个点:
 * > root新建的位置 是在for for里的，每一个i都要做一回root
 * > 必须要加空指针， 才能让后面的for循环有意义
 *
 * 1/30/21.
 */
public class _95_unique_binary_search_trees_II {
    public List<TreeNode> generateTrees(int n) {
        if(n<1){
            return new LinkedList<>();
        }
        return getTree(1,n);
    }
    //和dfs不一样的? - 双边关系 复杂度？
    public List<TreeNode> getTree(int start, int end){
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(start > end){
            // why??
            res.add(null);
            return res;
        }
        // 理解结构 还是有些混乱
        for(int i=start; i<= end; i++){
            List<TreeNode> left = getTree(start, i-1);
            List<TreeNode> right = getTree(i+1, end);
            for(TreeNode nodeLeft: left){
                for(TreeNode nodeRight: right){
                    //重要的一句错了
                    TreeNode root = new TreeNode(i);
                    root.left = nodeLeft;
                    root.right = nodeRight;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
