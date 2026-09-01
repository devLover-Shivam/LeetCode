class Solution {
    public int maxProfit(int[] prices) {
        int minPrice= prices[0];
        int profit = 0;
        int maxProfit = 0;
        for(int i = 0 ; i < prices.length; i++){
            //calculate minimum price traversed so far
            minPrice = Math.min(minPrice, prices[i]);
            //calculate the profit for minPrice and the current price.
            profit = prices[i] - minPrice;
            //now updating maxProfit with each profit
            maxProfit = Math.max(maxProfit,profit);

        }
        return maxProfit;
    }
}