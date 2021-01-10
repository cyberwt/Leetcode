package tree.recursion;

import utils.TreeNode;

/**
 * 先不写代码，想想思路
 * find max in arr, then find next max 在左arr, find next max in 右arr, 是一块块如今去的
 *
 *
 TreeNode constructMaximumBinaryTree([3,2,1,6,0,5]) {
     // 找到数组中的最大值
     TreeNode root = new TreeNode(6);
     // 递归调用构造左右子树
     root.left = constructMaximumBinaryTree([3,2,1]);
     root.right = constructMaximumBinaryTree([0,5]);
     return root;
 }

 重新写一个函数控制索引
 build
 *
 *
 * 同任何一题一样，用queue or stack 去写 iterative
 *
 * 9/26/20.
 */
public class _654_maximum_binary_tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int start, int end){
        //设置机制, 让mid安全- 安全的变动left,right 的值
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int index = start;
        for(int i=start;i<=end; i++){
            if(nums[i]>nums[index]){
                index = i;
            }
        }
        //伪前序的方法
        TreeNode node = new TreeNode(nums[index]);
        node.left = start==index ? null :build(nums, start,index-1);
        node.right = end==index ? null: build(nums,index+1,end);
        return node;

    }

}
