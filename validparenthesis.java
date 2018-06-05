class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        for(int i = 0; i < len; i++) {  //create a stack of only invalid positions, between these positions are valid strings
            if(arr[i] == '(')
                stack.push(i);
            else {
                if(!stack.isEmpty()) {
                    if(arr[stack.peek()] == '(')
                        stack.pop();
                    else
                        stack.push(i);
                }
                else
                    stack.push(i);
            }
        }
        if(stack.isEmpty())
            return len;
        int a = len;
        int b = 0;
        while(!stack.isEmpty()) {
            b = stack.pop();
            answer = Math.max(answer, a - b - 1);
            a = b;
        }
        answer = Math.max(answer, a);   //for cases like "(()". 
        return answer;
    }
}
