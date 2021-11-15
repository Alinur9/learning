import java.util.HashMap;

public class LFUCache {
    private int cap;
    private int size=0;
    private int minfreq=0;
    HashMap<Integer,List> freqMap;
    HashMap<Integer,Node> map;

    class Node{
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    class List{
        int listSize;
        Node head;
        Node tail;
        public List(){
            this.head=new Node(0,0);
            this.tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            this.listSize=0;
        }
        public void addNode(Node n){
            Node nextNode = head.next;
            n.next = nextNode;
            nextNode.prev = n;
            n.prev = head;
            head.next =  n;
            listSize++;
        }
        public void removeNode(Node n)
        {
            Node prevNode = n.prev;
            Node nextNode = n.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }
    LFUCache(int capacity){
        this.cap = capacity;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            Node temp = n;
            updateList(n);
            return temp.value;
        }
        return -1;

    }

    public void put(int key, int value) {
        if(cap==0) return;
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.value=value;
            updateList(n);
        }
        else if(size<cap)add(key,value);
        else {
            evict();
            add(key,value);
        }
    }

    public void evict(){
        List l = freqMap.get(minfreq);
        map.remove(l.tail.prev.key);
        l.removeNode(l.tail.prev);
        size--;
    }

    public void updateList(Node n){
        int freq = n.freq;
        List l = freqMap.get(freq);
        l.removeNode(n);
        if(freq==minfreq && l.listSize==0){
            minfreq++;
        }
        n.freq++;
        List newList = freqMap.getOrDefault(n.freq,new List());
        newList.addNode(n);
        freqMap.put(n.freq,newList);
    }

    void add(int key,int value){
        Node toAdd = new Node(key,value);
        minfreq = 1;
        List l = freqMap.getOrDefault(1,new List());
        l.addNode(toAdd);
        freqMap.put(1,l);
        map.put(key,toAdd);
        size++;
    }
}
