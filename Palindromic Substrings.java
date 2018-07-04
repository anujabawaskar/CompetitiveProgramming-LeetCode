class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for(int i=s.length()-1; i >= 0; i--){
            for(int j=i; j < s.length(); j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i+1 > j-1 || dp[i+1][j-1]);
                if(dp[i][j])
                    ++count;
            }
        }
        return count;
    }
}
