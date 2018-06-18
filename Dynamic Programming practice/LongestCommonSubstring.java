// Java implementation of finding length of longest 
// Common substring using Dynamic Programming
public class LongestCommonSubSequence 
{
	/* 
	Returns length of longest common substring 
	of X[0..m-1] and Y[0..n-1] 
	*/
	static int LCSubStr(char X[], char Y[], int m, int n) 
	{
		int[][] dp = new int[m + 1][n + 1];
		int result = Integer.MIN_VALUE;
		for(int i = 0; i <= m; i++)
		    dp[i][0] = 0;
		for(int j = 0; j <= n; j++)
		    dp[0][j] = 0;
		for(int i = 1; i <= m; i++) {
		    for(int j = 1; j <= n; j++) {
		        if(X[i - 1] == Y[j - 1]) {
		            dp[i][j] = dp[i - 1][j - 1] + 1;
		            result = Math.max(result, dp[i][j]);
		        }
		        else
		            dp[i][j] = 0;
		    }
		}
		return result;
	}
	
	// Driver Program to test above function
	public static void main(String[] args) 
	{
		String X = "OldSite:GeeksforGeeks.org";
		String Y = "NewSite:GeeksQuiz.com";

		int m = X.length();
		int n = Y.length();

		System.out.println("Length of Longest Common Substring is "
				+ LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
	}
}
