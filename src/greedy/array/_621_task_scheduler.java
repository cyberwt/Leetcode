package greedy.array;

import java.util.Arrays;

/**
 *  1. Arrays.sort 反向不好排序
 *  2. 理解  Math.max(tasks.length;, (arr[25]-1)*(n+1)+base )
 *  因为tasks.length 是所有操作的基础，在其上做相应改变
 *
 *  T:(N) S:O(N)
 * 3/22/21
 *
 *
 * M1: Greedy
 *  if we need idle, means all the number already in the arrays,
 *  maximum len =  (count_of_most_frequncy_task -1) *(n+1) + count_of_tasks_with_most_frenquency
 *
 *  else no idel need:
 *
 *
 *  The length of this arr is determined by the most frequent characters, we need to arrange them first,
 *  to make sure , they have a n internal space between them
 *
 *  record how to get the frequency with n and + the base length
 *
 *  how many group to arrange
 *   *n
 *
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
    // not sort, still can track  under each loop
    public int leastInterval2(char[] tasks, int n) {
        if(tasks == null || tasks.length ==0){
            return 0;
        }
        int[] records = new int[26];
        int max = 0;
        int count = 0;
        // count is the base length
        // max is the frequency of n
        for(char task:tasks){
            records[task-'A']++;
            if(records[task-'A'] > max){
                max = records[task-'A'];
                count = 1;
            }else if(records[task-'A'] == max){
                count++;
            }

        }
        int res = Math.max(tasks.length, (max -1)*(n+1) + count );
        return res;
    }
}
