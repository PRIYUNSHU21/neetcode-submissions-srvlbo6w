class Solution {
    //we are using a greedy approach here:
    // we take a min variable to keep track of the min value encountered so far
    // then we subtract the value in the array at current iteration with the min value and compare it to the max profit..and keep the max value
    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int max_profit = 0;

        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < min)
            {
                min = prices[i];
            }
            else
            {
                if((prices[i]-min) > max_profit)
                {
                    max_profit = prices[i] - min;
                }
            }
        }

        return max_profit;
    }
}
