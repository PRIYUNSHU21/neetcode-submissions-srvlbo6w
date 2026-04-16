class Solution {
    /*
        the logic is we create three arrays 
        array one stores prefix products
        array two stores suffix products
        result array stores the multiplication of the two array elements

        eg:    1 2 3 4 
        ar1:  24 12 4 1}-> this one along with the next 1 at ar2 position 0 has been put to facilitate multiplication
        ar2:  1   1  2 6 
    */
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
