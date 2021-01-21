package bfs;

import java.util.*;

/**
 *
 *  依旧很多potential error:
 * 1.漏掉了size同层限制
 * for(i<size)
 * 2. 数据类型要初始化好，linkedlist 后面要用的 HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
 * 3. bus line不是等长的
 * 4. 对于每一站，我加的是车号，放到set里的也是车号(整行的信息可以被skip)
 *  if(visited.contains(cur)) continue;
 * 5. 特殊情况，我就是我
    if(S==T) return 0;
 * 6.理解为什么数据会有这个含义
 *  HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
 *
 *
 *  1/20/21
 *
 *  So clever as a new data structure :=  to make sure
 *          <站台号,车号>！
 *   HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
 *
 * > what I need in queue to catch and pull again && visited check
 *
 *  T:O(E*V)
 *  S:O(E)
 *
 *  1/19/21.
 */
public class _815_bus_routes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int ret = 0;

        if (S==T) return 0;

        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                //站台号，车号
                map.put(routes[i][j], buses);
            }
        }

        q.offer(S);
        while (!q.isEmpty()) {
            int len = q.size();
            ret++;
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                ArrayList<Integer> buses = map.get(cur);
                for (int bus: buses) {
                    // let visited 车-> 每条数组
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        // let's visited 数组里里的元素
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
