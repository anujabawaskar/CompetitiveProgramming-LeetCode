class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        if (S == null || S.length() == 0) return S;
        int n = shifts.length;
        char[] temp = S.toCharArray();
        
        for (int i = n-1; i >= 0; i--) {
            if (i == n-1) {
                shifts[i] = shifts[i] % 26;
            } else {
                shifts[i] = (shifts[i] % 26 + shifts[i+1] % 26) % 26;
            }
            
            temp[i] = (char)((temp[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        
        return new String(temp);
    }
}
