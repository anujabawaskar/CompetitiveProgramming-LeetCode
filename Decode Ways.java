class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s == null)
            return 0;
        
        int[] dp = new int[len];
        
        //dp[0] = 1;  //0 length string
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 1; i < len; i++) {
            int curr = s.charAt(i) - '0';
            int two = Integer.parseInt(s.substring(i - 1, i + 1));
            if(curr >= 1 && curr <= 9)
                dp[i] = dp[i] + dp[i - 1];
            if(two >= 10 && two < 27) {
                if(i == 1)
                    dp[i] = dp[i] + 1;
                else
                    dp[i] = dp[i] + dp[i - 2];
            }
                
        }
        
        return dp[len - 1];
    }
}
