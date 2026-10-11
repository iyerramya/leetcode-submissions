class LRUCache {
    int capacity;
    Map<Integer, DoublyLinkedNode> map;
    DoublyLinkedNode head;
    DoublyLinkedNode tail;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new DoublyLinkedNode(-1, -1);
        this.tail = new DoublyLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        DoublyLinkedNode node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DoublyLinkedNode oldNode = map.get(key);
            remove(oldNode);
        }

        DoublyLinkedNode node = new DoublyLinkedNode(key, value);
        map.put(key, node);
        add(node);

        if(map.size() > capacity) {
            DoublyLinkedNode nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }        
    }

    public void add(DoublyLinkedNode node) {
        DoublyLinkedNode prevEnd = tail.prev;
        prevEnd.next = node;
        node.prev = prevEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(DoublyLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class DoublyLinkedNode {
    DoublyLinkedNode prev;
    DoublyLinkedNode next;
    int key;
    int value;

    public DoublyLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */