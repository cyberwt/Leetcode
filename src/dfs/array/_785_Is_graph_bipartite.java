package dfs.array;

/**
 *
 * 如果临近不能同色，那么每次本地为0，就fill, 然后继续dfs 用相反的色fill
 * 不用怕重复fill， 因为我判断的是 colors[index] = color
 *
 * 相对应： 染色问题
 *
 * T:O(N) S:O(N)
 *
 *5/21/21.
 */
public class _785_Is_graph_bipartite {
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0){
            return false;
        }
        int row = graph.length;
        int col = graph[0].length;
        int[] colors = new int[row];
        for(int i=0; i<row; i++){
            if(colors[i] == 0 && !fillColor(i,graph,1,colors)){
                return false;
            }
        }
        return true;
    }

    public boolean fillColor(int index,int[][] graph, int color, int[] colors){
        if(colors[index] != 0){
            return color == colors[index];
        }
        // dfs 一直往下扫
        colors[index] = color;
        for(int val: graph[index]){
            if (!fillColor(val, graph,-color,colors)){
                return false;
            }
        }
        return true;
    }
}
