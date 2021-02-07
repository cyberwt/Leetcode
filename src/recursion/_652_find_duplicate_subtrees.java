package recursion;

import utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 哪种iterative方法: 为什么是postorder, 看的其实是:
 * String left = traverse(root.left);
   String right = traverse(root.right);
   String subTree = left + "," + right + "," + root.val;

 //左右子树加上自己，就是以自己为根的二叉树序列化结果
   String subTree = left + "," + right + "," + root.val;
 *
 * 2. 两个点入手:
 * 怎么确定:
 *  > 1、以我为根的这棵二叉树（子树）长啥样？ - Serialization
 *  > 2、以其他节点为根的子树都长啥样？ - set, evolute to hashmap to record count
 *
 *
 * 3. 返回值，从string 变换为 treeNode
 *  结果是 res.add(node) ，这个node，会自动把他的字数信息按reference吃的结构贴上去
 *
 * T:O(N) S:O(1)
 * 2/7/21.
 */
public class _652_find_duplicate_subtrees {
    // 要listnode 返回的是string怎么办
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<TreeNode> res = new LinkedList<TreeNode>();
        dfs(root, map, res);
        return res;
    }
    // can I ignore specified type for map
    // return what to make sure this string has meaning
    public String dfs(TreeNode node, HashMap<String, Integer> map, List<TreeNode> res){
        if(node == null) return "#";
        String str = dfs(node.left,map, res)+"," + dfs(node.right,map,res)+"," + node.val;
        int cnt = map.getOrDefault(str,0);
        if(cnt == 1){
            res.add(node);
        }
        map.put(str,cnt+1);
        return str;
    }
}
