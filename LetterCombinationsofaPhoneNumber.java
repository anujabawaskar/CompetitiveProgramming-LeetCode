class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits == null || digits.length() == 0)
            return answer;
        answer.add("");
        for(int i = 0; i < digits.length(); i++) {
            answer = combine(map[digits.charAt(i) - '0'], answer);
        }
        return answer;
    }
    public List<String> combine(String s, List<String> list) {
        List<String> temp = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++) {
            for(String sub:list) {
                temp.add(sub + s.charAt(i));
            }
        }
        return temp;
    }
}
