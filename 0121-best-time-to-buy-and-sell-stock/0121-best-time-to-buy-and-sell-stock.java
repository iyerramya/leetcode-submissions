class Solution {
    public int maxProfit(int[] prices) {
        int buy =0;
        int sell = 0;
        int max = 0;
        while(buy < prices.length && sell<prices.length) {
            if(buy == sell) {
                sell++;
                continue;
            }
            if(prices[buy] > prices[sell]) {
                buy++;
            } else if(prices[buy] == prices[sell]) {
                sell++;
            } else if(prices[buy] < prices[sell]) {
                max = Math.max(max, prices[sell]-prices[buy]);
                sell++;
            }
        }
        return max;
    }
}