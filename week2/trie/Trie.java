import java.util.*;

class TrieNode {
    char val;
    TrieNode [] arr = new TrieNode[26];
    boolean isWord;
    TrieNode() {};
    
}

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode newNode = root;
        for (int i=0; i< word.length(); i++) {
            char temp = word.charAt(i) ;
            if (newNode.arr[temp - 'a'] == null) {
                newNode.arr[temp - 'a'] = new TrieNode();
            }
            newNode = newNode.arr[temp - 'a'];
        }
        newNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ptr = root;
        for (int i=0; i< word.length(); i++) {
            char temp = word.charAt(i);
            if (ptr.arr[temp - 'a'] == null) return false;
            
            ptr = ptr.arr[temp - 'a'];
        }
        
        return ptr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for (int i=0; i<prefix.length(); i++) {
            char temp = prefix.charAt(i);
            if (ptr.arr[temp - 'a'] == null) return false;
            
            ptr = ptr.arr[temp - 'a'];
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