class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] first = s1.toCharArray();
        Arrays.sort(first);
        String first1 = String.valueOf(first);
        char[] temp = new char[first.length];
        int len = s1.length();
        for(int i = 0; i < s2.length() - len + 1; i++) {
            temp = s2.substring(i, i + len).toCharArray();
            Arrays.sort(temp);
            if(String.valueOf(temp).equals(first1))
                return true;
        }
        return false;
    }
}
