package array.merge_two_pointer_overlap.scheduling;

import java.util.TreeMap;

/**
 * TreeMap: Use the natural ordering of its keys, sorted in the map
 *
 * map.lowerKey(): Returns the greatest key strictly less than the given key,
 *        or null if there is no such key.
 *
 * M2: Binary Search Tree 的完美体现
 * // why node don't need initialize?
 * -- return new TreeNode(start, end); // here do the initialization
 *
 * Error:
 * 1. if else if 不是非得查进去，没有变flog, 就会return false
 * 2. 初始化 内部class TreeNode
 *
 * 2/14/21.
 */
public class _729_my_calendar_I {
    TreeMap<Integer, Integer> map;
    public _729_my_calendar_I() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);

        if(low == null || map.get(low) <= start) {
            map.put(start, end);
            return true;
        }
        return false;
    }


    // M2: it's a pretty great binary search problem

    private TreeNode root;
    private boolean found;

    public _729_my_calendar_I(int x) {
        this.found = false;
    }

    public boolean book2(int start, int end) {
        if (end < start || start < 0) {
            return false;
        }
        // ! insert will always return root node
        root = insert(root, start, end);
        if (found) {
            found = false;
            return true;
        } else {
            return false;
        }
    }

    private TreeNode insert(TreeNode node, int start, int end) {
        if (node == null) {
            found = true;
            return new TreeNode(start, end);
        }
        if (node.start >= end) {
            node.left = insert(node.left, start, end);
        } else if (node.end <= start) {
            node.right = insert(node.right, start, end);
        }
        return node;
    }

    private class TreeNode {
        public int start;
        public int end;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
