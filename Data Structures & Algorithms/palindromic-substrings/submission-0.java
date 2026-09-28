class Solution {
    public int countSubstrings(String s) {

        int n = s.length();

        if(n == 0)return 0;
        if(n == 1)return 1;

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);

        int count = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                if(palin(dp,s,n, i, j) == 1)
                {
                    count++;
                }
            }
        }

        return count;
        
    }

    public int palin(int[][]dp,String s, int n, int start, int end)
    {
        if(start >= end)
        {
            return 1;
        }

        if(dp[start][end] != -1)
        {
            return dp[start][end];
        }

        if(s.charAt(start) == s.charAt(end))
        {
            dp[start][end] = palin(dp,s,n,start+1,end-1);
            return dp[start][end];
        }
        else
        {
            dp[start][end] = 0;
            return dp[start][end];
        }
    }
}
