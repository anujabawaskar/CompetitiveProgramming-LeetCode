class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int count = 0;
        for(int n : nums) {
            if(n == 1) 
                count++;
            else {
                answer = Math.max(answer, count);
                count = 0;
            }
                
        }
        answer = Math.max(answer, count);
        return answer;
    }
}
