class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];

        int[] dp = new int[nums.length + 2];

        for(int i = nums.length - 1; i >= 0; i--)
        {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
        
    }
}
