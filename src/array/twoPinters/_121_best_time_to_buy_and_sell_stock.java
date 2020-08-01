package array.twoPinters;

/**
 * 是不是可以理解成，然后就应该是这个值为最小的值
 * 恒取Math.min 作为最边界
 *
 * 取最小的值(buy,sell)，双指针，然后确定 到底是不是最优解
 * 7/30/20.
 */
public class _121_best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<= 1){
            return 0;
        }
        int min = prices[0];
        int res = 0;

        for(int i=1; i<prices.length; i++){
            res = Math.max(res, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }


}
