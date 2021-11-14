public class MyLinkedList<T> {

    private Node head = new Node(" Head of the linked list. User cannot access this. ");
    private int size = 0;

    void add(T data){
        Node  x = new Node(data);
        Node i = head;
        while(i.next!=null)
        {
            i=i.next;
        }
        i.next=x;
        size++;
    }
    void add(int index,T data) throws IndexOutOfBoundsException{
        if(index> size || index<0){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
        }
        Node x = new Node(data);
        Node i= head;
        int j=0;
        while(j<index){
            i=i.next;
            j++;
        }
        x.next = i.next;
        i.next = x;
        size++;
    }
    void remove(int index) throws IndexOutOfBoundsException{
        if(index<0 || index> size -1){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
        }
          Node i = head;
          int j = 0;
          while(j<index){
              i = i.next;
              j++;
          }
          //i.next=null;
          /*if(i.next.next==null){
              i.next=null;
          }else {

           */
        i.next = i.next.next;

        //}
          size--;
    }
    Object get(int index) throws NullPointerException,IndexOutOfBoundsException{
        Node i = head.next;
        int j=0;
        if(index<0 || index > size -1){
            throw new IndexOutOfBoundsException("index "+index+" is not a valid index for size "+ size);
        }
            while(j<index){
                i=i.next;
                j++;
        }

            return i.data;
    }
    void printlist(){
        Node t = head.next;
        while(t!=null){
            System.out.println(t.data);
            t=t.next;
        }
    }
    int size(){
        return size;
    }
}
