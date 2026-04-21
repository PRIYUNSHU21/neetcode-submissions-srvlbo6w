class Solution {
    /*
        The logic:
            first we sort the num array given in descending order
            then on that sorted array we run 1 loop over each of its element across the length of the array num -2
            for that element selected in one given given iteration: we get the left (starting frm thr next element) and right (starting from the farthest)
            sum of these three indice's elements is compared to 0.
            if its zero : elements are added to list
            if its less than zero: left pointer is increased by 1
            if its greater than zero: right pointer is decreased by 1

            now there should be another note in eliminating the duplicates: for tht  we use if conditions and if duplicates arrive..we increase the value of the points
     */
    public List<List<Integer>> threeSum(int[] nums)
 {      
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-2; i++ )
        {
            if(i>0 && nums[i] == nums[i-1])continue;
            int left = i+1;
            int right = nums.length-1;


            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0)
                {
                    List<Integer> trap = new ArrayList<>();
                    trap.addAll(Arrays.asList(nums[i],nums[left],nums[right]));
                    result.add(trap);
                    while(left<right && nums[left] == nums[left+1])left++;
                    while(left<right && nums[right]== nums[right-1])right--;
                    left++;
                    right--;
                }
                else if(sum > 0)
                {
                    right--;
                }
                else
                {
                    left++;
                }
            }
        }

        return result;
 }
    
}