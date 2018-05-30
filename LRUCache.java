class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node head, tail;
    private int capacity;
    private Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key) || map == null)
            return -1;
        else {
            Node node = map.get(key);
            updateOrder(node);  //put this node at the beginning of the queue
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() == capacity) {
                removeLRU();
            }
            Node node = new Node(key, value);
            addNode(node);  //insert this node at the beginning of the queue
            map.put(key, node); //create entry in hash map
        }
        else {
            Node node = map.get(key);
            updateOrder(node);  //bring this node to the front
            node.value = value; //change the value of this key
        }
    }
    
    public void removeLRU() {   //remove from tail, i.e. the least used item
        map.remove(tail.key);
        if(head == tail){   //only one item in the queue
            head = null;
            tail = null;
            return;
        }
        
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        tail = newTail;
    }
    
    public void updateOrder(Node node) {
        if(node == head)    //already at the right position
            return;
        if(node == tail) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }
    public void addNode(Node node) {
        if(head == null) {  //no item in the queue, add it
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
