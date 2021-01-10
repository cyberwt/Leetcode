package microsoft.oa;

import java.util.Arrays;

/**
 * Created by weitong on 9/19/20.
 */
public class oa_Min_Steps_to_Make_Piles_Equal_Height {
    public int minSteps(int[] piles){
        int len = piles.length;
        if(len <= 1) return 0;
        Arrays.sort(piles);
        int res = 0, distinctNums = 0;
        for(int i = 1; i < len; ++i){
            if(piles[i] != piles[i - 1]){
                ++distinctNums;
            }
            res += distinctNums;
        }
        return res;
    }
}
