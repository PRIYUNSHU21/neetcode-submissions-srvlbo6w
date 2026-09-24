
class Solution {
    public int climbStairs(int n) {

        if(n == 0)return 0;
        if(n == 1)return 1;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        backtrack(n, dp, 0);

        return dp[0];
    }

    public int backtrack(int n, int[] dp, int index)
    {
        if(index == n)return 1;
        if(index > n)return 0;

        if(dp[index] != -1)return dp[index];
        int store = 0;

        for(int i = 1; i < 3; i++)
        {
            store += backtrack(n, dp, index+i);
            
        }

        dp[index] = store;

        return dp[index];
    }
}
