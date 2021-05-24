package bfs;

import java.util.*;

/**
 *
 * set + queue 不要重复visited -> 常规： while + for size loop!
 * set里放string就行，不用放int[]
 *
 * Two tricks here:
 * > ;
 *
 *   x = Math.abs(x);
    y = Math.abs(y);

   ?
  > if (!visited.contains(newX + "," + newY) && newX >= -2 && newY >= -2)
 *  限制不要跑太远,因为他的范围是要在其坐标限制之内可以达到的
 *
 * T:O(M*N) because I have a set, overlap visited
 *
 * S:O();
 *
 * 4/8/21.
 */
public class _1197_minimum_knight_moves {
    private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return result;
                }

                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[] {newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            result++;
        }
        return -1;
    }
   // dp solutions to record the steps I needed
    public int minKnightMoves3(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Map<String, Integer> memo = new HashMap<>();
        return helper(x, y, memo);
    }

    private int helper(int x, int y, Map<String, Integer> memo) {
        String key = x + ":" + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }
        int min = Math.min(helper(Math.abs(x - 1), Math.abs(y - 2), memo),
                helper(Math.abs(x - 2), Math.abs(y - 1), memo)) + 1;
        memo.put(key, min);
        return min;
    }
}
