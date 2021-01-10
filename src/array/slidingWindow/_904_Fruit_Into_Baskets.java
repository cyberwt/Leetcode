package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 很巧妙的事我只要记录连续的 lastFruitCount,而不需要记录在这个串里本身有多少个数了
 *
 *   T:O(N) S:O(1)
 * 10/21/20.
 */
public class _904_Fruit_Into_Baskets {
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0){
            return -1;
        }


        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int res = 0;
        int curRes = 0;

        for(int fruit: tree){
            if(fruit == lastFruit || fruit == secondLastFruit){
                curRes++;
            }else{
                curRes = lastFruitCount+1;
            }

            if(fruit == lastFruit){
                lastFruitCount++;
            }else{
                lastFruitCount = 1;
            }

            if(fruit!= lastFruit){
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            res = Math.max(res, curRes);
        }
        return res;
    }

    // O(N)  O(N)
    public int totalFruit2(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        int res = Integer.MIN_VALUE;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
