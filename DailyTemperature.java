class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<Integer>();
        int len = temperatures.length;
        int answer[] = new int[len];
        for(int i = 0; i < len; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {   //update all days for which current temperature is more
                int index = s.pop();
                answer[index] = i - index;
            }
            s.push(i);
        }
        return answer;
    }
}
