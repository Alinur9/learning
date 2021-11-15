import jdk.jshell.JShell;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class MyHashmap <K,V>{
    V value;
    HashNode[] array;
    boolean replaced;
    int capacity = 4;
    int size = 0;
    public MyHashmap(){
        array  = new HashNode[capacity];
    }
    public MyHashmap(int buckets){
        capacity = buckets;
        array  = new HashNode[capacity];
    }
    public int hash(K key){
        byte[] data = SerializationUtils.serialize((Serializable) key);
        int hashKey = 0;
        int power = data.length - 1;
        for (int i = 0; i < data.length; i++) {
            int a = data[i];
            hashKey += a*power;
            if (power > 1)
                power--;
        }
        return hashKey;
    }
    public boolean contains(K key){
        int hashKey = hash(key);
        int index = Math.abs(hashKey%capacity);
        HashNode head = array[index];
        if (head.key == key)
            return true;
        else {
            while (head.next != null){
                head = head.next;
                if (head.key == key)
                    return true;
            }
            return false;
        }
    }
    public void put(K key, V value){

        int hashKey = hash(key);
        int index = Math.abs(hashKey%capacity);
        if (array[index] == null)
        array[index] = new HashNode<K,V>(key,value);
        else if (contains(key)){
            HashNode update = getNode(key);
            update.value = value;
            replaced = true;
        }
        else {
            HashNode head = array[index];
                if (head.next != null) {
                HashNode previousNode;
                while (head.next != null) {
                    previousNode = head;
                    head = head.next;

                }

                }
            head.next = new HashNode(key, value);
        }
        if (!replaced)
        size++;
    }
    public HashNode getNode(K key) {
        int hashKey = hash(key);
        int index = Math.abs(hashKey%capacity);
        HashNode head = array[index];
        if (head.key == key)
            return head;
        else {
            while (head.next != null){
                head = head.next;
                if (head.key == key)
                    break;

            }
            return head;
        }
    }
    public V get(K key) {
        int hashKey = hash(key);
        int index = Math.abs(hashKey%capacity);
        HashNode head = array[index];
        if (head.key == key)
        return (V) head.value;
        else {
            while (head.next != null){
                head = head.next;
                if (head.key == key) {
                    value = (V) head.value;
                    break;
                }
            }
            return value;
        }
    }
    public void remove(K key){
        int hashKey = hash(key);
        int index = hashKey%capacity;
        HashNode head = array[index];
        if (head.key == key){
            if (head.next == null)
                array[index] = null;
            else
                array[index] = head.next;
        }
        else {
            HashNode nextNode = head.next;
            if (nextNode.key == key){
                if (nextNode.next != null)
                    head.next = nextNode.next;
                else
                    head.next = null;
            }
            else {
                while (head.next != null) {
                    head = head.next;
                    nextNode = head.next;
                    if (nextNode.key == key) {
                        if (nextNode.next != null)
                            head.next = nextNode.next;
                        else
                            head.next = null;
                        break;
                    }
                }
            }
        }
        size--;
    }
}
