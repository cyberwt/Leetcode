package design.data_structure;

/**
 *
 *
 * treemap 确实清晰易懂
 *
 * 但实际我要的是，构建bst - with segment tree
 *
 *
 * 这种函数构建的很巧妙，他返回的永远是自己，如果本身自己是空的话，返回新TreeNode
 *
 *  分析复杂度 T:O(lgH) - 仅需要树的高度 S:O(1)
 *
 * 4/17/21.
 */
public class _729_my_calendar_I {
    private TreeNode root;
    private boolean found;
    public MyCalendar() {
        this.found = false;
    }

    public boolean book(int start, int end) {
        // corner case
        if(start> end || start < 0){
            return false;
        }
        root = insert(root, start, end);
        if(found){
            found = false;
            return true;
        }
        return false;

    }

    private TreeNode insert(TreeNode node, int start, int end){
        // help me do this initialzation first
        if(node == null){
            found = true;
            return new TreeNode(start, end);
        }

        // Error ! 可以取相等
        if(node.start >= end){
            // 为什么能直接向下插进去
            node.left = insert(node.left, start, end);
        }else if(node.end <=start){
            node.right = insert(node.right, start, end);
        }
        return node;
    }

    private class TreeNode{
        public int start;
        public int end;
        public TreeNode left, right;
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
