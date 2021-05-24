package google;

/**
 * Created by weitong on 4/24/21.
 */
public class number_of_island {
    int res = 0;
    public  int find_area(int[][] lake){
        if(lake == null || lake.length == 0){
            return 0;
        }

        boolean[][] visited = new boolean[lake.length][lake[0].length];
        for(int i=0;i<lake.length;i++){
            for(int j=0;j<lake[0].length;j++){
                if(lake[i][j] == 1){
                    dfs(visited, lake, i, j);
                }
            }
        }
        return res;

    }

    public int dfs(boolean[][] visited, int[][] lake, int row, int col){
        if(visited[row][col] || row<0 || col <0 || row>=lake.length || col>=lake[0].length){
            return 0;
        }
        if(row == 0 || col == 0 && lake[row][col] == 0){
            return 0;
        }

    }
}
