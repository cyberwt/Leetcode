package graph;

import java.util.*;

/**
 * DFS vs BFS
 *
 * 理解好两种算法的基础
 *
 * bfs先求出此列的最优解
 *
 * dfs
 * if contains 直接返回该node
 * 否则，返回我new clone node
 *
 *
 * 8/3/20.
 */
public class _133_clone_graph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Integer,Node> map = new HashMap<Integer,Node>();
        return dfs(node,map);
    }
    private Node dfs(Node node, HashMap<Integer,Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        } else {
            Node clone = new Node(node.val);
            map.put(node.val,clone);
            for (int i = 0; i < node.neighbors.size(); i++) {
                clone.neighbors.add(dfs(node.neighbors.get(i), map));
            }
            return clone;
        }
    }


    public Node cloneGraph2(Node node) {
        if(node == null){
            return node;
        }

        HashMap<Node, Node> map = new HashMap<Node, Node>();

        Queue<Node> queue = new LinkedList<Node>();

        map.put(node, new Node(node.val, new ArrayList<Node>()));

        queue.add(node);

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            for(Node neighbor: curNode.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
