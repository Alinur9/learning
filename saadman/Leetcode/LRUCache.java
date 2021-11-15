import java.util.HashMap;

public class LRUCache {
    private Node head = new Node(900000,9000000);
    private Node tail = new Node(990000,9900000);
    private HashMap<Integer,Node> hash= new HashMap<>();
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
         Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int cap;
    int size = 0;
    public LRUCache(int capacity) {
        this.cap= capacity;
    }

    public int get(int key) {
        if(hash.containsKey(key)){
            Node n = hash.get(key);
            Node temp = n;
            n.prev.next=n.next;
            n.next.prev=n.prev;
            size--;
            add(key,temp.value);

            return hash.get(key).value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(contains(key,value)) return;
        else if(size<cap) add(key,value);
        else{
            evict();
            add(key,value);
        }
    }
    void add(int key,int value){
        Node toAdd = new Node(key,value);
        hash.put(key,toAdd);
        if(size == 0){
            head.next=toAdd;
            toAdd.prev=head;
            toAdd.next=tail;
            tail.prev=toAdd;
        }
        else {
            toAdd.next = tail;
            toAdd.prev = tail.prev;
            tail.prev.next = toAdd;
            tail.prev = toAdd;
        }

        size++;
    }

    public void evict(){
            int key = head.next.key;
            hash.remove(key);
            head.next = head.next.next;
            head.next.prev = head;
            size--;
    }
    public boolean contains(int key,int value){

        if(hash.containsKey(key))
        {
            Node n = hash.get(key);
            Node temp = n;
            n.prev.next=n.next;
            n.next.prev=n.prev;
            size--;
            add(key,temp.value);
            return true;

        }
        return false;
    }


}
