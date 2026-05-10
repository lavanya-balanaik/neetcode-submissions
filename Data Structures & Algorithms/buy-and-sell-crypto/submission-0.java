class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        
        for(int price : prices) {
            minPrice = Math.min(minPrice, price); //best buy so far
            maxProfit = Math.max(maxProfit, (price - minPrice)); //best sell
        }
        return maxProfit;
    }
}
