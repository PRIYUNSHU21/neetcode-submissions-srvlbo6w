class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)return 0;
        if(s.length() == 1)
        {
            if(s.charAt(0) == '0')return 0;
            else return 1;
        }

        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);

        return solve(s,dp);
    }

    public int solve(String s,int[] dp)
    {
        if(s.length() == 0)return 1;
        if(s.length() == 1)
        {
            if(s.charAt(0) == '0')return 0;
            else return 1;
        }
        
        if(s.charAt(0) == '0')return 0;

        int length_remaining = s.length();

        if(dp[length_remaining] != -1)return dp[length_remaining];

        int dig1 = Integer.parseInt(s.substring(0,1));
        String one = s.substring(1, s.length());
        int max_one =  solve(one,dp);

        int dig2 = Integer.parseInt(s.substring(0,2));
        int max_two = 0;
        if(dig2 >= 10 && dig2 <= 26)
        {
            String two = s.substring(2, s.length());
            max_two = solve(two,dp);
        }

        dp[length_remaining] = max_one + max_two;

        return max_one + max_two;

    }
}
