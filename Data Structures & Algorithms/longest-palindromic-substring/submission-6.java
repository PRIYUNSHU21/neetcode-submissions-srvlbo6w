class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        if(n == 1)return s;
        if(n == 0)return null;

        int[][] dp = new int[n][n];

       for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for(int i = 0; i < n; i++)
        {
            dp[i][i] = 1;
        }

        int max = 1;
        int index = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j<n; j++)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    if(palin(dp, i+1, j-1, s) == 1)
                    {
                       if(j-i+1 > max)
                       {
                        max = j-i+1;
                        index = i;
                       }
                    }
                }
            }
        }

        return s.substring(index, index + max);
    }

    public int palin(int[][] dp, int start, int end, String s)
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
            dp[start][end] = palin(dp, start + 1, end - 1, s);
            return dp[start][end];
        }
        else
        {
            dp[start][end] = 0;
            return dp[start][end];
        }
    } 
}
