package microsoft;

/**
 *  区间，nucket sort,每个值都有自己的桶
 *  然后去看到底是哪个桶被积累的最大
 *  9/24/20.
 */
public class population {
    public int findMaxPopulation(int[][] records){
        if(records == null || records.length == 0){
            return 0;
        }
        int[] nums = new int[2100-1900];
        for(int i=0; i<records.length; i++){
            nums[records[i][0]-1900] ++;
            nums[records[i][1]-1900+1] --;
        }
        for(int i=0; i<10; i++){
            System.out.println((i+1900) + ":" + nums[i+90]);
        }
        int pre =0;
        int maxP = 0;
        int res =0;
        for(int j=0; j<nums.length; j++){
            pre+=nums[j];
            if(pre>maxP){
                maxP = pre;
                res = j;
            }
        }
        return res+1900;
    }

    public static void main (String[] args){
        population solution = new population();
        int[][] test = {{1990,1999},{1993,1996},{1995,1998}};
        System.out.println(solution.findMaxPopulation(test));
    }
}
