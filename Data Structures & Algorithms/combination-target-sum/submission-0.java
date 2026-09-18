class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(result, temp, nums, target, 0);

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
            temp.add(nums[i]);

            backtrack(result, temp, nums, target - nums[i], i);

            temp.remove(temp.size() - 1);

        }
    }
}
