package greedy.array;

import java.util.Arrays;

/**
 * 两边同时Iterate,
 * 第一遍 左->右 满足条件
 * 第二遍 右->左 满足条件
 * 且要做一个判断: if((ratings[j-1] > ratings[j]) &&(candies[j-1] <= candies[j])){
 *
 * 8/10/20.
 */
public class _135_candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1; i<candies.length; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] += candies[i-1];
            }
        }

        for(int j=candies.length-1; j>=1; j--){
            if((ratings[j-1] > ratings[j]) &&(candies[j-1] <= candies[j])){
                candies[j-1] = candies[j]+1;
            }
        }
        int res=0;
        for(int candy: candies){
            res += candy;
        }

        return res;
    }
}
