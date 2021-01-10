package dfs.array;

import java.util.HashSet;

/**
 *
 * ans = no. of rocks- no. islands = no. of rocks I can remove
 *
 * 怎么理解Steps
 *
 * 1.Problems:
 * Remove a stone if and only if there's another stone in the same col or row
 *
 * Try to remove as many as stones as possible.
 *
 * 2.How to solve:
 * Connected stones can be reduced to 1 stones,
 * the maximum stones can be removed = stones number - islands number
 *
 * So here what we need is islands number
 *
 * 3. Connected stones
 *
 * the best strategy, we can remove until 1 stone.
 *
 *
 * M1: dfs T:O(N^2) S:O(N)
 * 理解 number of islands
 *
 * dfs
 * 1. 退出条件 set.contains(stone)
 * 2. visited mark住
 * 3。符合条件，就继续向下dfs
 *
 * 8/23/20.
 */
public class _947_most_stones_removed_with_same_row_or_column {
    public int removeStones(int[][] stones) {
        if(stones == null || stones.length <= 1) return 0;
        HashSet<int[]> set = new HashSet<int[]>();
        int count = 0;
        for(int[] stone: stones){
            if(!set.contains(stone)){
                dfs(stone, stones,set);
                count++;
            }
        }
        return stones.length - count;
    }

    public void dfs(int[] stone, int[][] stones, HashSet<int[]> set){
        if(set.contains(stone)){
            return;
        }
        set.add(stone);
        for(int[] val:stones){
            if(val[0] == stone[0] || val[1] == stone[1]){
                dfs(val,stones,set);
            }
        }

    }

   // M2 union find

    int[] unions = new int[1000];
    public int removeStones2(int[][] stones) {
        int len = stones.length;
        for (int i = 0; i < len; i++){
            unions[i] = i;
        }

        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++){
            if (unions[i] == i) count++;
        }

        return len - count;
    }

    private void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x == y) return;
        unions[y] = x;
    }

    private int find(int x){
        if (unions[x] == x) return x;
        return find(unions[x]);
    }

}
