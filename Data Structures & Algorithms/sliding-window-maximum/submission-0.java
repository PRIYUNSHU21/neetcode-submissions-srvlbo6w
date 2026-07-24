class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0 || nums == null)
        {
            return new int[1];
        }

        int total = nums.length;
        int j = 0;

        int[] result = new int[ total - k + 1];
        Deque<Integer> box = new ArrayDeque<>();

        for(int i = 0; i < total; i++)
        {
            int window = i - k + 1;

            //frontal element eviction
            if(!box.isEmpty() && box.peekFirst() < window)
            {
                box.pollFirst();
            }

            while(!box.isEmpty() && nums[box.peekLast()] <= nums[i] )
            {
                box.pollLast();
            }

            box.offerLast(i); //storing the indices

            if(i >= k-1)
            {
                result[j] = nums[box.peekFirst()];
                j++;
            }


        }

        return result;
        
    }
}
