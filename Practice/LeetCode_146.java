class Node {
    int key, val;
    Node prev, next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private final int CAP;
    private Node head, tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        CAP = capacity;
        head = new Node(-1, -1);
        tail = new Node(-2, -2);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        Node node = map.get(key);
        
        if (node == null) {
            return -1;
        }
        
        remove(node);
        addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == CAP) {
                Node removeNode = removeLast();
                map.remove(removeNode.key);
            }
            node = new Node(key, value);
            map.put(key, node);
            addFirst(node);
            return;
        }
        
        node.val = value;
        remove(node);
        addFirst(node);
    }
    
    public void remove(Node removeNode) {
        Node prev = removeNode.prev, next = removeNode.next;
        prev.next = next;
        next.prev = prev;
        removeNode.next = null;
        removeNode.prev = null;
    }
    
    public void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }
    
    public Node removeLast() {
        Node removeNode = tail.prev;
        Node last = removeNode.prev;
        last.next = tail;
        tail.prev = last;
        removeNode.next = null;
        removeNode.prev = null;
        return removeNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
