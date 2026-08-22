class Solution {
    public int rob(int[] nums) {

        int prev1 = 0, prev2 = 0;
        int max = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if((nums[i] + prev2) > prev1)
            {
                int temp = prev2;
                prev2 = prev1;
                prev1 = nums[i] + temp;
                max = Math.max(max, prev1);
            }
            else
            {
                prev2 = prev1;
            }
        }

        return max;
        
    }
}
