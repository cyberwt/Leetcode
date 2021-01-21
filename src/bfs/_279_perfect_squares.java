package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * R:
 * 还是老结构
 * if(!set.contains(num-j*j)){
 set.add(num-j*j);
 queue.add(num-j*j);
 }
 更好理解
 *
 * E: - > can skip
 * > 没理解 if(!set.add(val)) continue
 * 下面的循环，就是分析，val 的，如果之前被分析过了，说明没有符合情况==0，可跳过
 * > 忘掉了加queue.add(val- j*j)
 *
 * 1/17/21
 *
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
    public int numSquares(int num) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        if(num >0) queue.offer(num);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int val = queue.poll();
                for(int j=1; j<=Math.sqrt(val); j++){
                    if(val-(j*j) == 0) return level;
                    if(!set.contains(num-j*j)){
                        set.add(num-j*j);
                        queue.add(num-j*j);
                    }
                }
            }
        }

        return level;
    }
}
