class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;
        if(nums.length < 2)
            return nums[0];
        
        return Math.max(helper(new int[nums.length], nums, 0, nums.length - 1), helper(new int[nums.length], nums, 1, nums.length));
    }
    public int helper(int[] dp, int[] num, int low, int high) {
        if(low == 0) {
            dp[0] = num[0];
            dp[1] = Math.max(num[0], num[1]);
        }
        else
            dp[1] = num[1];
        
        for(int i = 2; i < high; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        
        return dp[high - 1];
    }
}
