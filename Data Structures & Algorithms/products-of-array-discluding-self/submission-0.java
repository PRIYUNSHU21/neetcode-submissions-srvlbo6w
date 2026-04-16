class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];
        
        prefix[nums.length-1] = 1;

        for(int j=nums.length-1; j>0; j--)
        {
            prefix[j-1] = prefix[j]*nums[j]; 
        }
        suffix[0] = 1;
        for(int i=0; i<nums.length-1; i++)
        {
            suffix[i+1] = suffix[i]*nums[i];
        }
        for(int k=0; k<nums.length; k++)
        {
            result[k] = prefix[k]*suffix[k];
        }

        return result;

    }
}  
