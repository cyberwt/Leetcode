package array.sort.bucksort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Note:
 *  > When, we use priority queue - get a fix frequency
 *  > How to integerate with hashmap， strange but useful
 *  PriorityQueue<Integer> pq = new PriorityQueue<Integer>((num1,num2)->map.get(num1) - map.get(num2) )
 *
 *  for(int key: map.keySet()){
        pq.add(key);
        if(pq.size() == k+1){
            pq.poll();
     }
    }
 *
 * 1/27/21
 *
 * M1: bucket sort, 先用 hashmap 存freq, 再反存bucket[freq] 的 bucket Sort
 *
 * M2: priority queue 构建堆
 *
 * 9/29/20.
 */
public class _347_top_k_frequent_elements {
    public int[] topKFrequent2(int[] nums, int k) {
        if(nums == null || nums.length < 0){
            return nums;
        }

        // give me a hashmap<integer, integer> first
        // then I transfer it to a bucket
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // here need an extra pos!
        LinkedList<Integer>[] buckets = new LinkedList[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new LinkedList<Integer>();
            }
            buckets[freq].add(key);

        }
        int[] res = new int[k];
        int index =0;
        for(int i=buckets.length-1; index<k && i>=0; i--){
            if(buckets[i] == null){
                continue;
            }
            for(int val: buckets[i]){
                res[index++] = val;
                if(index == k){
                    return res;
                }
            }

        }

        return res;

    }


    public int[] topKFrequent(int[] nums, int k) {
        // input's limitation => isUnique
        if(nums == null || nums.length ==0){
            return nums;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            // calculate the frequency
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // 这种结构的适用情况
        // 怎么使用
        // get k most
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((num1, num2)->map.get(num1) - map.get(num2) );

        for(int key: map.keySet()){
            pq.add(key);
            if(pq.size() == k+1){
                pq.poll();
            }
        }
        int[] top = new int[k];
        for(int i=k-1;i>=0;i--){
            top[i] = pq.poll();
        }
        return top;
    }
}
