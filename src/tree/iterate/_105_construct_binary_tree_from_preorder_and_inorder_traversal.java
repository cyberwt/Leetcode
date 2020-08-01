package tree.iterate;

import utils.TreeNode;

import java.util.HashMap;

/**
 *
 * M1:
 * 递归，不断向下走，注意边界的定义
 * 在end时， 是取不到的值！ 因为放的就是取不到的   !! 注意这里的边界情况，包括左边界，不包括右边界
 *
 * M2:
 * 用hashmap, 记录index.value, 就不用再次loop
 *
 *  07/23
 */
public class _105_construct_binary_tree_from_preorder_and_inorder_traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder,int i_start, int i_end){
        if(p_start == p_end){
            return null;
        }

        int val = preorder[p_start];
        TreeNode root = new TreeNode(val);

        int i_root_index = 0;

        for(int i=i_start; i<i_end; i++){
            if(inorder[i] == preorder[p_start]){
                i_root_index = i;
                break;
            }
        }
        int numLeft = i_root_index - i_start;
        root.left = buildTree(preorder, p_start+1, p_start+1+numLeft, inorder, i_start, i_root_index);
        root.right = buildTree(preorder, p_start+1+numLeft, p_end, inorder, i_root_index+1, i_end);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
                                     HashMap<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
        return root;
    }

}
