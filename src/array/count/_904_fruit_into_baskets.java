package array.count;

import java.util.HashMap;

/**
 * > map<Integer,Integer> ->   value, cnt
 * if cnt == 0 map.remove(value, 0)
 * >cnt比存index更好理解, index也可以限定
 * map.remove(value,left) -> map.remove(tree[left],left);
 *
 * T:O(N) S:O(1)- map only stores 2 values
 *
 * 4/17/21.
 */
public class _904_fruit_into_baskets {
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int cnt =0;
        int left =0, right=0;
        while(right < tree.length){
            map.put(tree[right],right);
            while(map.size() == 3){
                map.remove(tree[left],left);
                left++;
            }
            cnt = Math.max(cnt, right-left+1);
            right++;
        }
        return cnt;
    }
}
