class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<String>(wordList);
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String temp = q.poll();
                char[] arr = temp.toCharArray();
                for(int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String newWord = String.valueOf(arr);
                        
                        if(dict.contains(newWord)) {
                            if(newWord.equals(endWord))
                                return level + 1;
                            
                            q.add(newWord);
                            dict.remove(newWord);
                            
                        }
                    }
                    arr[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
