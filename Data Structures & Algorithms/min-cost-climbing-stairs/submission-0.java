class Solution {
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
