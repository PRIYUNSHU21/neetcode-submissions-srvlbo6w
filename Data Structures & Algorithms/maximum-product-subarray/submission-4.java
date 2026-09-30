class Solution {
    public int maxProduct(int[] nums) {

        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];

        int neg = 1;
        int pos = 1;
        int max = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i >= 0; i--)
        {
            neg *= nums[i];
            pos *= nums[i];
            if(pos <= 0)
            {
                int temp = Math.max(neg,pos);
                max = Math.max(temp,max);
                pos = 1;
                continue;
            }
            int temp = Math.max(neg,pos);
            max = Math.max(temp,max);
        }
        neg = 1;
        pos = 1;

        for(int i = 0; i < nums.length; i++)
        {
            neg *= nums[i];
            pos *= nums[i];
            if(pos <= 0)
            {
                int temp = Math.max(neg,pos);
                max = Math.max(temp,max);
                pos = 1;
                continue;
            }
            int temp = Math.max(neg,pos);
            max = Math.max(temp,max);
        }
        
        return max;
    }
}
