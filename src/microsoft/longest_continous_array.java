package microsoft;

/**
 * what is a continous arr
 * > means diff is 1 = index difference
 *
 * i，j各自的起始值
 *
 * miss when len ==1
 *  9/6/20.
 */
public class longest_continous_array {
    private int solve(int[] arr){
        int res = 0;
        if( arr.length <= 1 ){
            return arr.length;
        }

        for(int i=0 ;i<arr.length-1; i++){
            int min = arr[i], max = arr[i];
            for(int j=i+1; j<arr.length; j++){
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if(max-min == j-i){
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        longest_continous_array solution = new longest_continous_array();
        int[] arr = {1,-5,-4,1,4,5};
        int res = solution.solve(arr);
        int[] arr2 = {1};
        int res2 = solution.solve(arr2);
        System.out.println(res + " " + res2);
    }

}
