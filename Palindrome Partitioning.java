class Solution {    // see image at - https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java:-Backtracking-solution.
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        
        backtrack(answer, temp, 0, s);
        
        return answer;
        
    }
    
    public void backtrack(List<List<String>> answer, List<String> temp, int start, String s) {
        if(temp.size() > 0 && start >= s.length()) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(answer, temp, i + 1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
}
