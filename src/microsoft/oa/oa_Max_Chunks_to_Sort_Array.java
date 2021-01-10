package microsoft.oa;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_Max_Chunks_to_Sort_Array {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n];
        rightMin[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i] = Math.min(arr[i], rightMin[i+1]);
        }

        int count = 0, max = arr[0];
        for(int i=0;i<n;i++){
            max = Math.max(max, arr[i]);
            if(i==n-1 || max <= rightMin[i+1]) count++;
        }
        return count;
    }
}
