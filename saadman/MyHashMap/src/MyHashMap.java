import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.HashMap;

public class MyHashMap<X,Y>{
    private static class Node{
        Object key;
        Object data;
        Node next;
        Node(Object key, Object data)
        {
            this.key = key;
            this.data = data;
        }
    }

    //This is a test comment
    private int capacity=10;
    //This is a test comment
    private Node[] table;
    //This is a test comment(2)
    private int size = 0;

    public MyHashMap() {
        this.capacity = 10;
        this.table = new Node[capacity];
    }

    public MyHashMap(int capacity){
        this.capacity=capacity;
        this.table=new Node[capacity];
    }


    private int getIndex(X key){
       // byte[] arr =  SerializationUtils.serialize((Serializable) key);
        return Math.abs(key.hashCode()%capacity);

    }

    public void put(X key, Y data)
    {

        int index = getIndex(key);
        if(updateData(key,data))return;
       else if(table[index]==null)
        {
            table[index] = new Node(key, data);
        }
        else {
            Node pointer = table[index];
            while (pointer.next!=null)
            {
                pointer=pointer.next;
            }
            pointer.next = new Node(key, data);
        }
    }

    public Object get(X key){
        int index = getIndex(key);

        Node pointer = table[index];
        while (pointer!=null)
        {
            if(pointer.key == key) return pointer.data;
            pointer=pointer.next;
        }
        return null;
    }

    public boolean containsKey(X key)
    {
        int index = getIndex(key);
        if(table[index]!=null){
            Node pointer = table[index];
            while (pointer!=null)
            {
                if(pointer.key==key) return true;
                pointer = pointer.next;
            }
        }
        return false;
    }

    private boolean updateData(X key, Y data){
        int index = getIndex(key);
        Node pointer = table[index];
        while (pointer!=null){
            if(pointer.key==key){
                pointer.data=data;
                return true;
            }
            pointer= pointer.next;
        }
        return false;
    }

    public void remove(X key){
        int index = getIndex(key);
        if(table[index]==null)return;

        if(table[index].key==key) {
            Node temp = table[index];
            table[index] = table[index].next;
            temp = null;
        }
        else {
            Node pointer = table[index];
            while (pointer.next!=null){
                if(pointer.next.key==key){
                    pointer.next=pointer.next.next;
                    break;
                }
                pointer=pointer.next;
            }
        }
    }
}
