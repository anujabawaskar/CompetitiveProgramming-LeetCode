class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums)
            sum = sum + n;
        
        if(sum % 2 != 0)
            return false;
        
        sum = sum / 2;
        int len = nums.length;
        
        boolean[][] dp = new boolean[len + 1][sum + 1];
        
        dp[0][0] = true;
        for(int i = 1; i <= sum; i++)
            dp[0][i] = false;
        
        for(int i = 1; i <= len; i++ )
            dp[i][0] = true;
        
        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j >= nums[i - 1])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[len][sum];
    }
}
