package bfs.djikstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Note:
 * 第一次做djistra - 局部最优，到该点的最短距离 <Dist, Node> ，跟上一个poll出来的node没有任何关系了，目的是驾到全局变量里
 * 1. Map<Integer, Map<Integer,Integer>> 为了更好取得图上的路径信息- 由二维数组转换过来的 --- map.put!!
 * Map<Integer, Map<Integer,Integer>>
 * 2. Queue<int[]> queue = new PriorityQueue<>((a,b) -> (a[0] - b[0]))
 *  int[] means <Dist, Node>
 * 3。什么情况下继续loop 放值
 * if(map.containsKey(curNode)){
       for(int next : map.get(curNode).keySet()){
           pq.add(new int[]{curDist + map.get(curNode).get(next), next});
   }
 }4. if(visited[curNode]) prevent res be updated to a longer distance
 *5.
 * Dijkstra cannot handle negative weighted edges.
 *
 * Time:
 *
 * E is at most V^2.
 *
 * First, acknowledge that PQ can grow to size E, since we're just dumping all the neighbors into the PQ.
 * Hence, PQ poll() and add() takes O(log E)
 * Forget the while loop, focus on the total times you're polling and adding to PQ.

   total poll = V b/c process each node once.
   total add = E b/c always just dumping every neighbor (which is associated with an edge) into PQ.

   Hence, we have O(V log E + E log E) = O(E log E).

   We can make this even prettier, as this guy says, E = O(V^2). That is to say, the number of edges in the worst case = V^2.

   O(E log V^2) = O(E * 2 log V) = O(E log V)
 *
 * Space:
 * O(E)
 *
 *
 * 1/19/21.
 */
public class _743_network_delay_time {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N+1];
        int res = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if(N==0) return res; // improve for cut down the count
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;

    }

}
