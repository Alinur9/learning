import java.util.HashMap;

public class LruCache {
    int capacity;
    HashMap<Integer,DoublyNode<Integer>> nodes = new HashMap<>();
    HashMap<Integer,Integer> cache = new HashMap<>();
    DoublyNode<Integer> head = new DoublyNode<>(-1,0);
    DoublyNode<Integer> previousNode;
    DoublyNode<Integer> tail = new DoublyNode<>(-1,10);
    boolean contains = false;

    public LruCache(int capacity){
        this.capacity = capacity;
    }
    public int get(int key){
        int ret = -1;
        if (cache.containsKey(key)){
            ret = cache.get(key);
            DoublyNode<Integer> toUpdate = getNode(key);
            toUpdate.previous.next = toUpdate.next;
            toUpdate.next.previous = toUpdate.previous;
            tail.previous.next = toUpdate;
            toUpdate.previous = tail.previous;
            toUpdate.next = tail;
            tail.previous = toUpdate;
        }
        return ret;
    }
    private DoublyNode<Integer> getNode(int key){
        DoublyNode<Integer> ret = nodes.get(key);
        return ret;
    }
//    private DoublyNode<Integer> getNode(int key){
//        DoublyNode<Integer> iterator = head;
//        while (iterator.next != null){
//            iterator = iterator.next;
//            if (iterator.key == key)
//                return iterator;
//        }
//        return null;
//    }
    public void put(int key, int value){
        contains = false;
        if (cache.containsKey(key))
            contains = true;
        cache.put(key,value);
        if (cache.size() == 1) {
            DoublyNode<Integer> next = new DoublyNode<>(key, value);
            head.next = next;
            next.previous = head;
            next.next = tail;
            tail.previous = next;
            previousNode = next;
            nodes.put(key, next);
        }
        else {
            DoublyNode next = new DoublyNode(key,value);
            if (contains){
                DoublyNode<Integer> oldNode = getNode(key);
                DoublyNode<Integer> oldPrevious = oldNode.previous;
                DoublyNode<Integer> oldNext = oldNode.next;
                oldPrevious.next = oldNext;
                oldNext.previous = oldPrevious;
                tail.previous.next = next;
                next.previous = tail.previous;
                next.next = tail;
                tail.previous = next;
                nodes.put(key,next);
            }
            else {
                tail.previous.next = next;
                next.previous = tail.previous;
                next.next = tail;
                tail.previous = next;
                nodes.put(key,next);
                if (cache.size() > capacity){
                    DoublyNode<Integer> toRemove = head.next;
                    head.next = toRemove.next;
                    toRemove.next.previous = head;
                    cache.remove(toRemove.key);
                    nodes.remove(toRemove.key);
                }

            }

        }

    }

}
