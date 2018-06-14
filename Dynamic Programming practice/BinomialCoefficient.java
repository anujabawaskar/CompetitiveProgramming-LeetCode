
class BinomialCoefficient
{
	// Returns value of Binomial Coefficient C(n, k)
	static int binomialCoeff(int n, int k)
	{
	int dp[][] = new int[n + 1][k + 1];
	for(int i = 0; i<= n; i++) {
	    for(int j = 0; j <= min(i, k); j++) {
	        if(j == 0 || i == j)
	            dp[i][j] = 1;
	        else
	            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
	    }
	}
	return dp[n][k];
	}

	// A utility function to return minimum of two integers
	static int min(int a, int b)
	{
	return (a<b)? a: b; 
	}

	/* Driver program to test above function*/
	public static void main(String args[])
	{
	int n = 5, k = 2;
	System.out.println("Value of C("+n+","+k+") is "+binomialCoeff(n, k));
	}
}
/*This code is contributed by Rajat Mishra*/
