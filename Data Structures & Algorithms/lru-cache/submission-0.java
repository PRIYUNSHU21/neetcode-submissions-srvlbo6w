class LRUCache {

   class Node
   {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int k,  int v)
        {
            this.key = k;
            this.value = v;
        }
   }

   private final int capacity;
   private final HashMap<Integer, Node> map;
   private final Node head;
   private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if(map.containsKey(key))
        {
            Node con = map.get(key);
            remove(con);
            insert(con);
            return con.value; 
        }
        else
        {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key))
        {
            Node c = map.get(key);
            c.value = value;
            remove(c);
            insert(c);
        }
        else
        {
            Node d = new Node(key, value);
            map.put(key, d);
            insert(d);
        }

        if(map.size() > capacity)
        {
            int k = tail.prev.key;
            map.remove(k);
            remove(tail.prev);
        }
        
    }

    private void remove(Node n)
    {
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }
    private void insert(Node n)
    {
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
    }
}
