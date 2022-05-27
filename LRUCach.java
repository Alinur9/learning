import java.util.HashMap;

public class LRUCach {
       Node head = new Node(-1,-1);
       Node tail = new Node(-1,-1);

     static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

        int cap;
        HashMap<Integer, Node> hash ;

        public LRUCach(int capacity) {
            this.cap = capacity;
            hash = new HashMap<>();
           // HashMap<Integer,Node> t = new HashMap<>();
           // this.hash = t;
            head.next = tail;
            tail.prev = head;
        }
        public void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        public void moveToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
            }


        public int get(int key) {
            if (hash.containsKey(key)) {
                Node curr = hash.get(key);
                delete(curr);
                moveToHead(curr);
                return curr.value;
            }else{
                return -1;
                }
            }
        public void put(int key, int value) {
                if (hash.containsKey(key)) {
                    Node curr = hash.get(key);
                    curr.value = value;
                    delete(curr);
                    moveToHead(curr);
                }
                else if(hash.size() >= cap) {
                        Node curr = new Node(key, value);
                        hash.remove(tail.prev.key);
                        delete(tail.prev);
                        hash.put(key,curr);
                        moveToHead(curr);
                    } else {
                        Node curr = new Node(key, value);
                        hash.put(key, curr);
                        moveToHead(curr);
                    }
                }

        public static void main(String[] args){
             LRUCach lruCach = new LRUCach(2);

                lruCach.put(1,10);
                lruCach.put(2,20);
                System.out.println(lruCach.get(1));
                lruCach.put(3,30);
                System.out.println(lruCach.get(2));
                lruCach.put(4,40);
                 // lruCach.put(4,100);
               lruCach.put(5,50);
               System.out.println(lruCach.get(1));
               System.out.println(lruCach.get(3));
               System.out.println(lruCach.get(5));
               System.out.println(lruCach.get(4));
}
}
