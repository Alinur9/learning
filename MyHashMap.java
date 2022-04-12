package advance.com.company;

import java.util.HashMap;

public class MyHashMap {
    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;

        }
    }
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public MyHashMap() {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);

        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int result = node.value;

            return result;
        }
        return -1;

    }

    public void remove(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            deleteNode(node);

        }
    }

}
