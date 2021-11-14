
public class MyDLL<T> {
    private DLL_Node head = new DLL_Node(" Head of the doubly linked list. User cannot access this. ");
    private DLL_Node tail = new DLL_Node("Tail of the doubly linked list. User cannot access this.");
    private int size = 0;
    void add(T data){
      DLL_Node toAdd = new DLL_Node(data);
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
    void add(int index,T data) throws IndexOutOfBoundsException{
        if(index> size || index<0){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
        }
        DLL_Node toAdd = new DLL_Node(data);
        DLL_Node curr= head;
        if(size == 0){
            add(data);
        }
        else {
            int j = 0;
            while (j <= index) {
                curr = curr.next;
                j++;
            }
            toAdd.next = curr;
            toAdd.prev = curr.prev;
            curr.prev.next = toAdd;
            curr.prev = toAdd;
            size++;
        }

    }
    void remove(int index) throws IndexOutOfBoundsException{
        if(index<0 || index> size -1){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
        }
        DLL_Node curr = head;
        int j = 0;
        while(j<=index){
            curr = curr.next;
            j++;
        }

        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
        //}
        size--;
    }
    Object get(int index) throws NullPointerException,IndexOutOfBoundsException{
        DLL_Node curr = head.next;
        int j=0;
        if(index<0 || index > size -1){
            throw new IndexOutOfBoundsException("index "+index+" is not a valid index for size "+ size);
        }
        while(j<index){
            curr=curr.next;
            j++;
        }

        return curr.data;
    }
    void printlist(){
        DLL_Node curr = head.next;
        while(curr!=tail){
            System.out.println(curr.data);
            curr=curr.next;
        }

    }
    int size(){
        return size;
    }
}
