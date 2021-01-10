package microsoft.oa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_jump_game {
    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return canReach(arr, start, visited);
    }

    private boolean canReach(int[] arr, int start, boolean[] visited) {
        int x = arr[start];
        if(arr[start] == 0) return true;
        if(!visited[start]){
            visited[start] = true;
            if(start - arr[start] >= 0 && canReach(arr, start - arr[start], visited)) return true;
            if(start + arr[start] <= arr.length - 1 && canReach(arr, start + arr[start], visited)) return true ;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3, 0, 3, 1, 2, 1};
        oa_jump_game s = new oa_jump_game();
        System.out.println(s.canReach(nums, 7));
        int arr[] = {3, 4, 2, 3, 0, 5, 1, 2, 1};
        System.out.println(s.canReach(arr, 7));
    }

    public static boolean canReach2(int nums[], int start){
        if(nums[start] == 0){
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while(queue.size()>0){
            int curr = queue.poll();
            if(nums[curr] == 0){
                return true;
            }
            int index = curr - nums[curr];
            if(index >= 0 && !visited.contains(index)){
                visited.add(index);
                queue.offer(index);
            }
            index = curr + nums[curr];
            if(index < nums.length && !visited.contains(index)){
                visited.add(index);
                queue.offer(index);
            }
        }
        return false;
    }
}
