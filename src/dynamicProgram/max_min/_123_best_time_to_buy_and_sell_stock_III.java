package dynamicProgram.max_min;

/**
 * 就只要维持数组 再分别进行了无论 算不算这次买卖的最值
 * 第一次买卖
 * 第二次买卖
 *
 * 7/31/20.
 */
public class _123_best_time_to_buy_and_sell_stock_III {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 =0;
        for(int i=0; i<prices.length; i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, buy2+prices[i]);

        }
        return sell2;
    }

}
