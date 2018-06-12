class Solution {
    public int maxCoins(int[] oldNums) {
        int[] nums = new int[oldNums.length + 2];
        int n = 1;
        for (int x : oldNums) 
            if (x > 0) 
                nums[n++] = x;
        nums[0] = nums[n++] = 1;
        
        int dp[][] = new int[n][n];
        for(int i = 2; i < n; i++) {
            for(int left = 0; left < n - i; left++) {
                int right = left + i;
                for(int j = left + 1; j < right; j++) {
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[j] * nums[right] + dp[left][j] + dp[j][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
