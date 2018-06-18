// A Dynamic Programming solution for subset
// sum problem
class GFG {
	
	// Returns true if there is a subset of 
	// set[] with sun equal to given sum
	static boolean isSubsetSum(int set[], 
							int n, int sum)
	{
		boolean dp[][] = new boolean[n + 1][sum + 1];
		for(int i = 1; i <= sum; i++)
		    dp[0][i] = false;
		for(int i = 0; i <= n; i++)
		    dp[i][0] = true;
		    
		for(int i = 1; i <= n; i++) {
		    for(int j = 1; j <= sum; j++) {
		        //System.out.println(i + " " + j);
		        try {
		        if(j >= set[i - 1])
		            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
		        else
		            dp[i][j] = dp[i - 1][j];
		        }
		        catch(ArrayIndexOutOfBoundsException exception) {
		            System.out.println("here");
		            System.out.println(i + " " + j);
		        }
		    }
		}
		return dp[n][sum];
	}

	/* Driver program to test above function */
	public static void main (String args[])
	{
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset"
						+ " with given sum");
		else
			System.out.println("No subset with"
							+ " given sum");
	}
}

/* This code is contributed by Rajat Mishra */
