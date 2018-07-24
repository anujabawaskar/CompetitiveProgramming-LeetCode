class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
    
        List<String> answer = new ArrayList<String>();
        TrieNode root = createTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dfs(board, i, j, answer, root);
            }
        }
        return answer;    
    }
    
    public void dfs(char[][] board, int i, int j, List<String> answer, TrieNode p) {
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null)
            return;
        
        p = p.next[c - 'a'];
        if(p.word != null) {
            answer.add(p.word);
            p.word = null;
        }
        
        board[i][j] = '#';
        if(i > 0)
            dfs(board, i - 1, j, answer, p);        
        if(j > 0)
            dfs(board, i, j - 1, answer, p);
        if(i + 1 < board.length)
            dfs(board, i + 1, j, answer, p);
        if(j + 1 < board[0].length)
            dfs(board, i, j + 1, answer, p);
        board[i][j] = c;
        
    }
    public TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String s : words) {
            TrieNode temp = root;
            for(char c : s.toCharArray()) {
                if(temp.next[c - 'a'] == null)
                    temp.next[c - 'a'] = new TrieNode();
                
                temp = temp.next[c - 'a'];
            }
            temp.word = s;
        }
        return root;
    }
}
