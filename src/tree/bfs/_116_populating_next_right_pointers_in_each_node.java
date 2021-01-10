package tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 9.7 bfs 过了，但pre的处理没有那么简洁
 *
 * dfs什么意思
 * 因为是完全二叉树，直接摆阵，找left, right -> perfect binary tree makes it easy to list the node
 *
 * Created by weitong on 7/30/20.
 */
public class _116_populating_next_right_pointers_in_each_node {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node dummy = root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for(int i=0; i<size; i++){
                Node cur = queue.poll();
                if(i>0){
                    pre.next = cur;
                }

                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                pre = cur;
            }

        }
        return root;
    }


    public Node connect2(Node root) {
        dfs(root, null);
        return root;
    }

    public void dfs(Node node, Node next){
        if(node == null) return ;
        node.next = next;
        dfs(node.left,node.right);
        dfs(node.right, node.next == null ? null: node.next.left);
    }
}
