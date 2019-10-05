class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        
        for (int i=0 ; i<m ;i++ ) {
            for (int j=0; j<n; j++) {
                dfs(board, i, j, root, res);
            }
        }
        
        return res;
    }
    
    public void dfs(char [][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        
        if ( c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        
        if (i > 0) dfs(board, i-1, j, p, res);
        if (i <board.length - 1) dfs(board, i+1, j, p, res);
        if (j > 0) dfs(board, i, j-1, p, res);
        if (j < board[0].length -1) dfs(board, i, j+1, p, res);
        board[i][j] = c;
    } 
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String s: words) {
            TrieNode ptr = root;
            for (char c: s.toCharArray()) {
                if (ptr.next[c - 'a'] == null) {
                    ptr.next[c - 'a'] = new TrieNode();
                }
                ptr = ptr.next[c - 'a'];
            }
            
            ptr.word = s;
            // System.out.println(ptr.word);
        }
        
        return root;
    }
}