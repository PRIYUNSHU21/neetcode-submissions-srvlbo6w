class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += nums[i];
        }
        if(sum % 2 == 1)return false;

        int required = sum/2;

        Boolean[][] look = new Boolean[n][required + 1];
        return solve(nums, 0, required, look);
    }

    public boolean solve(int[] nums, int index, int required, Boolean[][] look)
    {
         if(index == nums.length || required < 0)return false;
         if(required == 0)return true;

         if(look[index][required] != null)return look[index][required];

        boolean skip = solve(nums, index + 1, required, look);
        boolean take = solve(nums, index + 1, required - nums[index], look);

        look[index][required] = skip || take;

        return look[index][required];
    }
}
