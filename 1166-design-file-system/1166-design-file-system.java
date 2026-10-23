class FileSystem {
    Node root;

    public FileSystem() {
        this.root = new Node(-1);  
    }
    
    public boolean createPath(String path, int value) {
        String[] parts = path.split("/");
        Node curr = root;

        for (int i = 1; i < parts.length - 1; i++) {
            if (!curr.children.containsKey(parts[i])) {
                return false; // parent missing
            }
            curr = curr.children.get(parts[i]);
        }

        String last = parts[parts.length - 1];
        if (curr.children.containsKey(last)) {
            return false; // path already exists
        }
        curr.children.put(last, new Node(value));
        return true;
    }
    
    public int get(String path) {
        String[] parts = path.split("/");
        Node curr = root;
        int value = -1;
        for(int i=1; i<parts.length; i++) {
            if(!curr.children.containsKey(parts[i])) {
                return -1;
            } else {
                curr = curr.children.get(parts[i]);
                value = curr.value;
            }
        }
        return value;
        
    }
}

class Node {
    Map<String, Node> children;
    int value;

    public Node(int value) {
        this.children = new HashMap<String, Node>();
        this.value = value;
    }

    public int getValue() {
        return value;
    }



}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */