package array.sort.bucksort;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * M1: bucket sort, 先用 hashmap 存freq, 再反存bucket[freq] 的 bucket Sort
 *
 * M2: priority queue 构建堆
 *
 * 9/29/20.
 */
public class _347_top_k_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
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
}
