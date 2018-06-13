class Solution {
    public int[] countBits(int num) {
        int[] answer = new int[num + 1];
        answer[0] = 0;
        for(int i = 1; i <= num; i++) {
            answer[i] = answer[i & (i - 1)] + 1;
        }
        return answer;
    }
}
