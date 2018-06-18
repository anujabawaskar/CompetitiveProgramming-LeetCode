// A Java program to count all possible paths 
// from top left to bottom right
class GFG 
{
	// Returns count of possible paths to reach 
	// cell at row number m and column number n from
	// the topmost leftmost cell (cell at 1, 1)
	static int numberOfPaths(int m, int n)
	{
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++)
		    dp[i][0] = 1;
		for(int j = 0; j < n; j++)
		    dp[0][j] = 1;
		
		for(int i = 1; i < m; i++) {
		    for(int j = 1; j < n; j++)
		        dp[i][j] = dp[i - 1][j] + dp[j][i - 1];
		}
		return dp[m - 1][n - 1];
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		System.out.println(numberOfPaths(3, 3));
	}
}
