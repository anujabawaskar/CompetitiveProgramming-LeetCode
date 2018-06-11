class Solution {
    int answer = 0;
    public int countArrangement(int N) {
        if(N == 0)
            return 0;
        helper(N, 1, new int[N + 1]);
        return answer;
        
    }
    public void helper(int n, int pos, int[] arr) {
        if(pos > n) {
            answer++;
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(arr[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                arr[i] = 1;
                helper(n, pos + 1, arr);
                arr[i] = 0;
            }
        }
    }
}
