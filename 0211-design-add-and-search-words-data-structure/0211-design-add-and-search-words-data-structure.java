class WordDictionary {
    Node root;

    class Node {
        Map<Character, Node> children;
        boolean isEnd;
        
        public Node() {
            this.children = new HashMap<>();  
            this.isEnd = false;      
        }
    }

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return find(0, word, root);
    }

    private boolean find(int i, String word, Node curr) {
        if(i == word.length()) {
           return curr.isEnd;
        }
        char c = word.charAt(i);
        if(c == '.') {
            for(Node child: curr.children.values()) {
                if(find(i+1, word, child)) {
                    return true;
                }
            }
            return false;
        } 
        if(!curr.children.containsKey(c)) {
            return false;     
        } 
        return find(i+1, word, curr.children.get(c));
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */