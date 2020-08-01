package array.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Error:
 *
 * 要建的是nums[len+1] -> 且 nums[0]= 0 那num 代表的是什么意思
 *
 * 左指针前进条件
 * while(queue.size()> 0 &&  nums[i] <= nums[queue.getLast()] )
 *
 *
 * 右指针满足情况，求解
 *
 *
 *
 * 7/11/20.
 */
public class _862_shortest_subarray_with_sum_at_least_K {
    public int shortestSubarray(int[] A, int K) {
        if(A==null || A.length == 0){
            return -1;
        }
        if(A.length == 1){
            return A[0]>=K ? A[0]:-1;
        }

        int res = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;

        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] nums = new int[A.length+1];

        for(int i=0; i<A.length; i++){
            nums[i+1] = nums[i]+ A[i];
        }


        for(int i=0;i<=A.length; i++){
            if(i ==1){
                System.out.println(queue.getLast() + " 123 " + nums[i] + " 123 "+i );
            }


            while(queue.size()> 0 &&  nums[i] <= nums[queue.getLast()] ){
                //System.out.println(queue.getLast() + " 123 " + nums[i] + " 123 "+i );
                queue.pollLast();
            }

            while(queue.size()> 0 && nums[i] - nums[queue.getFirst()] >= K ){
                res = Math.min (res, i-queue.pollFirst());
            }

            queue.addLast(i);
        }

        return res == Integer.MAX_VALUE ? -1: res;
    }
}

