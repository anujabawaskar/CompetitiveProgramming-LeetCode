class Solution {
	public static void main (String[] args) {
	    int n = 4;
    	int[] answer = new int[n + 1];
    	answer[0] = 0;
    	answer[1] = 1;
    	answer[2] = 2;
    	for(int i = 3; i <= n; i++)
    	    answer[i] = answer[i - 1] + answer[i - 2];
    	    
    	System.out.println(answer[n]);
	}
}
