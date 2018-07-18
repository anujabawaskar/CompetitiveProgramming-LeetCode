class Solution {
    public int longestSubstring(String str, int k) {
        char[] s = str.toCharArray();
        int[] freq = new int[26];
        int i, j, max = 0, unique, minK;
        int len = str.length();
        
        for(int times = 1; times <= 26; times++) {  //find upto 26 different chars in the string
            
            Arrays.fill(freq, 0);
            i = 0;
            j = 0;
            unique = 0;
            minK = 0;
            while(j < len) {
                if(unique <= times) { //still have to find more unique characters
                    int index = s[j] - 'a';
                    
                    if(freq[index] == 0)
                        unique++;
                    
                    freq[index]++;
                    
                    if(freq[index] == k)
                        minK++;
                    j++;
                    
                }
                else {
                    int index = s[i] - 'a';
                    if(freq[index] == k)
                        minK--;
                    
                    freq[index]--;
                    
                    if(freq[index] == 0)
                        unique--;
                    
                    i++;
                }
                if(unique == times && minK == times)    //there are unique characters and each repeats K times at least
                    max = Math.max(max, j - i);
            }
            
        }
        return max;
        
    }
}
