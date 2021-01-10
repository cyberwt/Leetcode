package array.twoPinters;

/**
 *
 * 想成一个线段树，不断的求解向上线段的 差值，然后向里加
 * 抽象理解一个数学问题
 *
 *
 * 7/30/20.
 *
 *
 * 2:
 * 借助数学其实是更好理解的
 *
 * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
 * 而 d - a = (d - c) + (c - b) + (b - a) ，
 * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，
 * 那么就把 prices[i] - prices[i-1] 添加到收益中。
 *
 *1/8/21
 *
 *
 */
public class _122_best_time_to_buy_and_sell_stock_II {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] - prices[i-1] > 0){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
