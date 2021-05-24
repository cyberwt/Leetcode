package facebook.onsite;

import java.util.PriorityQueue;

/**
 *
 *  https://leetcode.com/discuss/interview-question/1140838/Facebook-Stream-of-Unsorted-Intervals
 *
 *
 * M1: merge interval 的变形，当segment特别多时，换成
 *
 * TreeMap, get the desired key, related to the desired key
 *
 * 4/7/21.
 */
public class _download_file {

    // M1 use pq

    // Give me the smallest one
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(a,b ->(a[0] - b[0]));
    int N = 5;


    public boolean checkDownloadStatus(int [] range){
        if(range == null || range.length != 2) return false;
        if(pq.isEmpty()){
            pq.add(range);
        }
        int[] pre = pq.poll();
        for(int[] cur: pq){
            if(cur[0]> pre[1]){
                pq.add(pre);
                pre = cur;
            }else{
                pre[0] = pre[0];
                pre[1] = Math.max(pre[1], cur[1]);
            }

        }
        pq.add(pre);
        if(pq.size() ==1 && pre[0] == 0 && pre[1] == N){
            return true;
        }
        return false;
    }
}
