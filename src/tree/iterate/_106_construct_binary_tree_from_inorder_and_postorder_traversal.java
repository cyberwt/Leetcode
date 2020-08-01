package tree.iterate;

import utils.TreeNode;

import java.util.HashMap;

/**
 *
 * iterate的时候注意，不是一直都直通答案
 *
 * 质疑在过程中，有把谁filter掉
 *
 * 7/23/20.
 */
public class _106_construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end,
                                     HashMap<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        int root_val = postorder[p_end - 1];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(inorder, i_start, i_root_index, postorder, p_start, p_start + leftNum, map);
        root.right = buildTreeHelper(inorder, i_root_index + 1, i_end, postorder, p_start + leftNum, p_end - 1,
                map);
        return root;
    }
}
