package advance.com.company;


import java.util.HashSet;

public class MyHashSet {
    static class Node {
        int key;
        Node pre;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }
    private HashSet<Integer> set;
    private Node head, tail;

    public MyHashSet() {
        set = new HashSet<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public void put(int key) {
            Node node = new Node (key);
            set.add(key);
            addToHead(node);
        }

    public boolean contains(int key) {
        if (set.contains(key)) {
            return true;
        }
        return false;

    }

    public void remove(int key) {
        if (set.contains(key)) {
            set.remove(key);
        }
    }

}
