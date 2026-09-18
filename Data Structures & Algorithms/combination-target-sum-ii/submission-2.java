class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(result, temp, candidates, target, 0);

        return result;
    }

     public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        else if(target < 0)
        {
            return;
        }

        for(int i = start; i < nums.length; i++)
        {
            if(i > start && nums[i] == nums[i - 1])
            {
                continue;
            }
            temp.add(nums[i]);

            backtrack(result, temp, nums, target - nums[i], i+1);

            temp.remove(temp.size() - 1);

        }
    }
    
}
