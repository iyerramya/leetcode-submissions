class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int profit = 0;
        while(buy < prices.length && sell < prices.length) {
            if(buy == sell) {
                sell++;
                continue;
            }
            if(prices[buy] > prices[sell]) {
                buy++;
            }  else {
                profit += (prices[sell] - prices[buy]);
                buy++;
                sell++;
            }
        }
        return profit;
        
    }
}