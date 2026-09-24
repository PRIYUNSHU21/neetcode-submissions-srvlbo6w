class Solution {
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length == 0)return 0;
        if(cost.length == 1)return cost[0];

        int[] dp = new int[cost.length +2];

        for(int n = cost.length -1; n >= 0; n--)
        {
            dp[n] = cost[n] + Math.min(dp[n+1], dp[n+2]);
        }   

        return Math.min(dp[0], dp[1]);
    }
}
