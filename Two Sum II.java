class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int len = numbers.length;
        int low = 0;
        int high = len - 1;
        while(low < high) {
            int temp = numbers[low] + numbers[high];
            if(temp > target)
                high--;
            else if(temp < target)
                low++;
            else {
                answer[0] = low + 1;
                answer[1] = high + 1;
                return answer;
            }
        }
        return answer;
    }
}
