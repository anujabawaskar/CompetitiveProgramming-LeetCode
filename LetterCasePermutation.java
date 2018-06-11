class Solution {
    List<String> answer = new ArrayList<String>();
    public List<String> letterCasePermutation(String S) {
        char[] s = S.toCharArray();
        helper(s, 0, answer);
        return answer;
    }
    public void helper(char[] s, int pos, List<String> answer) {
        if(pos == s.length) {
            String val = String.valueOf(s);
            //if(!answer.contains(val))
                answer.add(val);
            return;
        }
        if(Character.isLetter(s[pos])) {
            s[pos] = Character.toLowerCase(s[pos]);
            helper(s, pos + 1, answer);
            s[pos] = Character.toUpperCase(s[pos]);
            
        }
        helper(s, pos + 1, answer);
    }
}
