class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        backtrack(result, temp, nums, check);

        return result;
    }


     public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums,boolean[] check)
    {
        if(temp.size() == nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(check[i] == true)continue;

            temp.add(nums[i]);
            check[i] = true;

            backtrack(result, temp, nums, check);

            check[i] = false;
            temp.remove(temp.size() - 1);

        }
    }
}
