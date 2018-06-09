class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<String>();
        backtrack("", 0, 0, answer, n);
        return answer;
    }
    public void backtrack(String s, int open, int close, List<String> answer, int max) {
        if(s.length() == max * 2) {
            answer.add(s);
            return;
        }
        if(open < max)
            backtrack(s + "(", open + 1, close, answer, max);
        if(close < open)
            backtrack(s + ")", open, close + 1, answer, max);
    }
}
