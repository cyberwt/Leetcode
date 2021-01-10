package greedy.array;

import java.util.Arrays;

/**
 *
 * M1: Greedy
 *  if we need idle, means all the number already in the arrays,
 *  maximum len =  (count_of_most_frequncy_task -1) *(n-1) + count_of_tasks_with_most_frenquency
 *
 *  else no idel need:
 *
 * M2: Priority Queue
 * 8/30/20.
 */
public class _621_task_scheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }
        int[] arr = new int[26];
        for(char val : tasks){
            arr[ val-'A']++;
        }
        Arrays.sort(arr);



        int count = 25;

        while(count>= 0 && arr[count] == arr[25]) count--;

        int base = 25 - count;
        return Math.max(tasks.length, (arr[25]-1)*(n+1)+base );

    }

}
