class Solution {
    public int maxProfit(int[] prices) { // [10,1,5,6,7,1]
        int maxP = 0;
        int l = 0, r = 1; // l = buy, r = sell

        while(r < prices.length){
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r +=1;
        }

        return maxP;        
    }
}
