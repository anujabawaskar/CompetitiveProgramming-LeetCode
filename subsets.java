class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    void backtrack(List<List<Integer>> result, int[] nums, List<Integer> temp, int start) {
        

        for(int i = start; i < nums.length; i++) {
            if(temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            backtrack(result, nums, temp, start+1);
            temp.remove(temp.size() - 1);
        }
    }
}
