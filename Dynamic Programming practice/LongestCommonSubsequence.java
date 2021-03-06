/* Dynamic Programming Java implementation of LCS problem */
public class LongestCommonSubsequence
{

/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
int lcs( char[] X, char[] Y, int m, int n )
{
	int dp[][] = new int[m + 1][n + 1];
	for(int i = 0; i <= m; i++)
	    dp[i][0] = 0;
	for(int i = 0; i <= n; i++)
	    dp[0][i] = 0;
	
	for(int i = 1; i <= m; i++) {
	    for(int j = 1; j <= n; j++) {
	        if(X[i - 1] == Y[j - 1])
	            dp[i][j] = dp[i - 1][j - 1] + 1;
	        else
	            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	    }
	}
	return dp[m][n];
}

/* Utility function to get max of 2 integers */
int max(int a, int b)
{
	return (a > b)? a : b;
}

public static void main(String[] args)
{
	LongestCommonSubsequence lcs = new LongestCommonSubsequence();
	String s1 = "AGGTAB";
	String s2 = "GXTXAYB";

	char[] X=s1.toCharArray();
	char[] Y=s2.toCharArray();
	int m = X.length;
	int n = Y.length;

	System.out.println("Length of LCS is" + " " +
								lcs.lcs( X, Y, m, n ) );
}

}
