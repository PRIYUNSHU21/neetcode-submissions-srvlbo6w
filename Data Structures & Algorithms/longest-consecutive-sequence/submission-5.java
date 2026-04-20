class Solution {
    /*
        for finding the longest sequence of digits in any given array..we can employ various strategies:
            -> hash set : removes duplicates from the array
            -> if we wanna get sequencial numbers like 1, 2, 3...or 100,101
            -> we notice there is one number like 1 or 100 whose minus components dont exist in the array
            -> if num-1 exist..then we move on the next element...this gets us that element which is minimum in any sequence
    */
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> contains = new HashSet<>();
        for(int num : nums )
        {
            if(!contains.contains(num))
            {
                contains.add(num);
            }
        }
       int longest = 1;
       for(int num : nums)
       {
          int count = 1;
          if(!contains.contains(num-1))
          {     
                int j = 1;
                while(contains.contains(num + j))
                {
                    count++;
                    j++;
                }
          }
          longest = Math.max(longest,count);
       }

       if(nums.length == 0){return 0;}
       else{return longest;}
      

    }
}