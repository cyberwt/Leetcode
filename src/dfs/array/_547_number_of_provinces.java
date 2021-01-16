package dfs.array;

/**
 * 单维度，一层for循环，
 * 进去之后，标成visited
 *
 * 1/14/21.
 */
public class _547_number_of_provinces {
    public int findCircleNum(int[][] isConnected) {
        // visited 不一定要是而为的，在这种无向图
        if(isConnected == null || isConnected[0].length == 0){
            return -1;
        }
        int m=isConnected.length;
        boolean[] visited = new boolean[m];
        int count =0;
        for(int i=0; i<m; i++){

            // visited 的出现要注意什么,如何标记
            // 单维无向，这样足够了么

            if(!visited[i]){
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int pos, boolean[] visited){
        visited[pos] = true;
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i] && isConnected[i][pos] == 1){
                dfs(isConnected, i, visited);
            }
        }
    }
}
