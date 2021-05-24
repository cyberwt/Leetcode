package facebook;

/**
 * Created by weitong on 2/28/21.
 */







public class List<int[]> aboveAverageSubarrays(int[] A) {
        // A need a CC check?

        // int[] left record all the left sum not include
        // int[] right all right su,

        // how the pointers move, since N is not bog, should be fine

        List<int[]> res = new LinkedList<>();
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i=1; i<len; i++){
        left[i] = left[i-1] + A[i-1];
        }
        for(int i=len-2; i>=0; i--){
        right[i] = right[i+1] + A[i+1];
        }
        // 马上越界
        int sum = 0;
        for(int i=0; i<len;i++){
        sum += A[i];
        }
        // single element stiil works
        for(int i=0; i< N; i++){
        for(int j=i; j<N;j++){
        int cnt = j-i+1;
        int remain = len-cnt;
        int avgCur = sum - left[i] - right[j];
        // use mutiply
        if(avgCur/cnt > (left[i] + right[j])/ remain){
        res.add(new int[]{i+1,j+1});
        }
        }
        }
        return res;
}