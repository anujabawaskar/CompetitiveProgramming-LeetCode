class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) // note : the loop runs from 1, not 0
            s = process(s);
        
        return s;
    }
    public String process(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 1; //note : not to be initialised to 0
        char[] temp = s.toCharArray();
        int len = temp.length;
        for(int i = 0; i < len; i++) {
            char c = temp[i];
            if(i + 1 < len && temp[i] == temp[i + 1]) { //check if next character is same
                count++;
                continue;
            }
            else {
                ans.append(count);
                ans.append(c);
                count = 1;
            }
        }
        return ans.toString();
    }
}
