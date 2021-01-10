package microsoft.oa;

import java.util.*;

/**
 * Created by weitong on 9/17/20.
 */
public class oa_count_Of_Hours_Variations {
    public List<List<Integer>> solve(int A, int B, int C, int D) {
        int[] t = new int[]{A, B, C, D};
        Arrays.sort(t);
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>());
        int index = 0;

        List<List<Integer>> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                List<Integer> polledTime = q.poll();

                if (!isValid(polledTime)) {
                    continue;
                }

                if (polledTime.size() == 4) {
                    if (!result.contains(polledTime))
                        result.add(polledTime);

                    continue;
                }

                for (int j = 0; j <= polledTime.size(); j++) {
                    List<Integer> newTime = new ArrayList<>(polledTime);
                    newTime.add(j, t[index]);
                    q.offer(newTime);
                }
            }
            index++;
        }
        return result;

    }

    private boolean isValid(List<Integer> polledTime) {
        if (polledTime.size() == 4 && polledTime.get(0) == 2
                && polledTime.get(1) == 4 && polledTime.get(2) == 5 &&
                polledTime.get(3) == 9)
            return true;

        if (polledTime.size() >= 1 && polledTime.get(0) > 2) {
            return false;
        }

        if (polledTime.size() >= 2 && polledTime.get(1) > 4) {
            return false;
        }

        if (polledTime.size() >= 3 && polledTime.get(2) > 5) {
            return false;
        }
        return true;
    }
}
