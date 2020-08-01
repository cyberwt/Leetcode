package tree.recursion;

import utils.TreeNode;

/**
 * 想清楚：
 *
 * 1。附加函数，到底返回是空，还是有解
 * 直接返回结果的 root, 不用多此一举， 把root设置为变量，搞错
 *
 *
 * 2。边界推出条件是什么，为什么: if(left < right) return null
 * 因为 当left == right 时，我还要继续取到这个值
 * 又要去理解这个函数的含义：
 * bfs(nums, left,right)
 *
 * left, right 都是还没有取的值
 *
 * 7/24/20.
 */
public class _108_convert_sorted_array_to_binary_search_tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        // mid = left + (right - left)/2

        return bfs(nums,0,nums.length-1);

    }


    // let me think, do I need to get the root first or after
    public TreeNode bfs(int[] nums, int left, int right){
        if(left > right) return null;

        int mid = left + (right -left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bfs(nums, left, mid-1);
        node.right = bfs(nums, mid+1, right);
        return node;

    }
}
