class MyHashMap {
    class ListNode {
        int key,val;
        ListNode next;
        
        ListNode (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public ListNode[] map; 
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new ListNode[10000];
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = idx(key);
        if (map[index] == null) {
            map[index] = new ListNode(-1,-1);
        }
        ListNode prev = find(map[index], key);
        if (prev.next == null) {
            prev.next= new ListNode(key,value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int idx(int key) {
        return Integer.hashCode(key) % map.length;
    }
    
    public ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = idx(key);
        if (map[index] == null) return -1;
        ListNode node = find(map[index], key);
        return node.next == null? -1: node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index  = idx(key);
        if (map[index] == null) return;
        ListNode node = find(map[index], key);
        if (node.next == null) {
            return;
        }
        node.next = node.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */