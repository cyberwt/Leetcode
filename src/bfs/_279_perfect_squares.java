package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Note:
 * > 去重做的很好 if(!set.add(val))  continue
 * > level 的变换 很巧妙，要放在前面，才使得 return level 不缺数
 *
 * > 并购条件
 *
 * for(){
 *     if(val == j*j) return level; // 在每层中，有符合条件的，即使是从小数开始变换
 *     queue.offer(val - (j*j))
 * }
 *
 * T:O(N) S:O(1)
 *
 * 1/11/21.
 */
public class _279_perfect_squares {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> reviewedSet = new HashSet<>();

        if(n >0) queue.offer(n);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int val = queue.poll();
                if(!reviewedSet.add(val)) continue;

                for(int j=1; j<=Math.sqrt(val); j++){
                    if(val-(j*j) == 0) return level;
                    queue.offer(val-(j*j));
                }
            }
        }

        return level;
    }
}
