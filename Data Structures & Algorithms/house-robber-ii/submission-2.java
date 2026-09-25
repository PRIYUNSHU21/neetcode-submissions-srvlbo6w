class Solution {// two loops run one between 0 to n-2 houses excluding the final house and once again by excluding the 0th house and including the last house so it would be 1 to n-1 houses.
    public int rob(int[] nums) {

        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];

        int[] dp = new int[nums.length + 2];

        for(int i = nums.length - 2; i >= 0; i--)
        {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        int max_so_far = dp[0];

         for(int i = nums.length - 1; i >= 1; i--)
        {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return Math.max(dp[1], max_so_far);
        
    }
}
