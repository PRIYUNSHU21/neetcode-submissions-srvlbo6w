class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0)return 0;
        if(nums.length == 1)return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int max = 0;

        for(int i = 0; i < nums.length; i++)
        {
            max = Math.max(solve(nums, dp, i)+1,max);
        }
        return max;
        
    }

    public int solve(int[] nums,  int[] dp, int index)
    {   

        if(index == nums.length)return 0;

        if(dp[index] != -1)return dp[index];
        int res = 0;

        for(int i = index+1; i < nums.length; i++)
        {
            if(nums[i] > nums[index])
            {
                res = Math.max(solve(nums, dp, i)+1, res);
            }
        }

        dp[index] = res;

        return dp[index];
    }
} 
