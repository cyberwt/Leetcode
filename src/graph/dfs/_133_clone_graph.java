package graph.dfs;

import java.util.*;

/**
 *
 * bfs理解错了 <node, node>, 往里连neighbor
 *
 * dfs重做
 *
 * 3/30
 *
 * 9/26
 * 没理解为什么dfs 什么时候会返回值，什么时候直接返空
 * >这里返回
 *
 * 没理解为什么bfs, 是每层怎么看，把neighbor 铺平
 *
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
        // Recursive solution. Use HashMap<Node, Node> instead of
        // HashMap<Integer, Node> to avoid the situation when nodes have same values
        return cloneGraphDFSHelper(node, new HashMap<Node, Node>());
    }
    public Node cloneGraphDFSHelper(Node node, HashMap<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node n : node.neighbors)
            newNode.neighbors.add(cloneGraphDFSHelper(n, map));
        return newNode;
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
