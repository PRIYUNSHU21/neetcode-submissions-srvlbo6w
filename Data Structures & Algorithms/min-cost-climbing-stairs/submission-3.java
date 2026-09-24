class Solution { // the top down approach for dp problem solving populates the dp table once it reaches the recursive left branch of the decision tree of a problem...the base case here when the index hits cost.length will be zero as there is no more cost to reach the intended top of the floors which is here depicted by size of the array.....the dp fills from the highest levels to the lowest levels....and the final answer to the  problem will be returned to the zeroth call made as all branches return the result to the top
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length == 0)return 0;
        if(cost.length == 1)return cost[0];

        int[] dp = new int[cost.length + 1];

        Arrays.fill(dp, -1);

        int start_from_0 = backtrack(cost, dp, 0);
        int start_from_1 = backtrack(cost,dp,1);

        return Math.min(start_from_0, start_from_1);
    }

    public int backtrack(int[] cost, int[] dp, int index)
    {
        if(index >= cost.length)return 0;

        if(dp[index] != -1)return dp[index];

        int store = Integer.MAX_VALUE;

        for(int i = 1; i < 3; i++)
        {
            int temp = backtrack(cost, dp, index+i);
            store = Math.min(store, temp);
        }

        dp[index] = cost[index] + store;

        return dp[index];
    }
}
