class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        char[] arr = s.toCharArray();
        for(String word : d) {
            int i = 0;
            for(char c : arr) {
                if(i < word.length() && c == word.charAt(i))
                    i++;
            }
            if(i == word.length() && word.length() >= longest.length()) {
                if(word.length() > longest.length() || word.compareTo(longest) < 0)
                    longest = word;
            }
        }
        return longest;
    }
}
