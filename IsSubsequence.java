class Solution {
    public boolean isSubsequence(String S, String T) {
        int s = 0, t = 0;
        int sLen = S.length();
        if(sLen == 0)
            return true;
        int tLen = T.length();
        while(t < tLen) {
            if(S.charAt(s) == T.charAt(t))
                s++;
            if(s == sLen)
                return true;
            t++;
        }
        return false;
    }
}
