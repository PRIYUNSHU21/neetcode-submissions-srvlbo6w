class Solution {
    public int[] twoSum(int[] nums, int target) {

       //using hash map for the solution: complement = target - nums[i]
       //if commpliment exists in hashmap then success, if no then put the element in hashMap
       //map.get....map.containsKey...operations usealed

       Map <Integer,Integer> sum = new HashMap<>();
       //.length() -> works for strings....for int use .length
       for(int i=0; i < nums.length; i++)
       {
            int compliment = target - nums[i];
            if(sum.containsKey(compliment))
            {
                return new int[] {sum.get(compliment),i};
            }
            sum.put(nums[i],i);
       }
       return new int[]{};
    }
}
