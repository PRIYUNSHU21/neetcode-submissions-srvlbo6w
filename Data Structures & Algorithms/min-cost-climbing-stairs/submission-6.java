class Solution {//this one is a bottom up approach...what we did is..we started from the leaves of the decision tree at the ceiling and top of the stairs we donot need to climb more so anything greater than cost.length will be 0...and the cost at any root at decision tree = cost of its level plus the minimum of the cost at two of its child levels...clever huh!!
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
