package dfs.graph;

import java.util.*;

/**
 *
 * 理解 把这些壳子拿掉，剩下bfs, dfs的skeleton
 *
 * dfs 就是一直不断的调用自己
 *
 * bfs 可以只要一个么，不可以，不太好分析，因为他还是要在for里去loop 全部的 node
 *
 * dfs T:O(N!) S:O(N^2)
 * bfs: T:O(N^2) S:O(N^2)
 *
 * bfs不一定就比dfs快，要看给的图到底是一个什么结构
 *
 *
 * 判断visited, 可以用boolean[]|[] or hashset/hashmap
 *-- 10/26
 *
 *
 * 9/28/20.
 */
public class _323_number_of_connected_components_in_an_Undirected_Graph {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] item : edges){
            graph.get(item[1]).add(item[0]);
            graph.get(item[0]).add(item[1]);
        }// done with building graph

        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                count++;
                // dfs(i,graph,visited);
                bfs(graph,i,visited);
            }
        }
        return count;
    }

    public void bfs(List<List<Integer>> graph, int i, HashSet<Integer> visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited.add(i);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbor : graph.get(curr)){
                if(!visited.contains(neighbor)){
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public void dfs(int i, List<List<Integer>> graph, HashSet<Integer> visited){
        visited.add(i);
        for(int num : graph.get(i)){
            if(!visited.contains(num)){
                dfs(num,graph,visited);
            }
        }
    }
}
