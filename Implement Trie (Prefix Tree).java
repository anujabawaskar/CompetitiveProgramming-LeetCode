class TrieNode {
    public char val;
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;
    
    public TrieNode() {
        
    }
    public TrieNode(char ch) {
        TrieNode node = new TrieNode();
        node.val = ch;
    }
}

public class Trie {
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.children[c - 'a'] == null)
                temp.children[c - 'a'] = new TrieNode(c);
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.children[c - 'a'] == null)
                return false;
            temp = temp.children[c - 'a'];
        }
        return temp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.children[c - 'a'] == null)
                return false;
            temp = temp.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
