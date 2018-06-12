class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if(s == null || len <= 1)
            return true;
        
        char[] arr = s.toCharArray();
        int start = 0, end = len - 1;
        int del = 0;
        while(start < end) {
            if(arr[start] == arr[end]) {
                start++;
                end--;
            }
            else {
                if(del == 0) {
                    del = 1;
                    return helper(arr, start + 1, end) || helper(arr, start, end - 1);
                    //del = 1;
                }
                else
                    return false;
            }
        }
        return true;
    }
    public boolean helper(char[] arr, int start, int end) {
        while(start < end) {
            if(arr[start] == arr[end]) {
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
}
