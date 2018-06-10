class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(T).equals(build(S));
    }
    public String build(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c:arr) {
            if(c != '#')
                stack.push(c);
            else {
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
