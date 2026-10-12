class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            } else {
                sell = prices[i];
                profit += (sell - buy);
                buy = prices[i];
            }
        }
        return profit;
    }
}