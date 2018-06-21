class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int answer = Math.min(helper(new int[len], 0, len, cost), helper(new int[len], 1, len, cost));
        
        
        return answer;
    }
    
    public int helper(int[] dp, int low, int high, int[] cost) {
        if(low == 0) {
            dp[0] = cost[0];
            dp[1] = Math.min(cost[1], dp[0] + cost[1]);
        }
        else {
           dp[0] = Integer.MAX_VALUE; 
           dp[1] = cost[1];
        }
        
        for(int i = 2; i < high; i++)
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
         
        
        return Math.min(dp[high - 1], dp[high - 2]);
    }
}
