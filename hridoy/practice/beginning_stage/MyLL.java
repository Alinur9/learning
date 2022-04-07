public class MyLL {
    private Node head = new Node("!!!!!");
    private Node tail = head;
    private int size = 0;

    public void add(Object data) {
        Node node = new Node(data);
        node.next = null;
        tail.next = node;
        tail = node;

     /*   Node temp = head;//!!!!
        while (temp.next != null) {
            temp = temp.next;//Traverse
        }
        temp.next = node;//else null = new data*/
        size++; // node internal size
    }

    public void insert(Object data, int index) {
        Node nodeInsert = new Node(data); //Ul Haque
        int index1 = index; //Ahsan
        Node temp = head;
       /* while (temp.next != null) {//check "if" condition //
            if (temp.data == index1) { //Otherwise traverse your node

                nodeInsert.next = temp.next; // after "if" condition get true // Ul Haque.next() + ahssan.next(Hridoy)
                temp.next = nodeInsert; //ahsan.next()+ nodeInsert-Ul Haque
                size++;
            }
            temp = temp.next;
        }*/
        int i;
        for ( i=0; i < index1 ;i++){
            temp = temp.next;
        }
        if ( i == index1){
            nodeInsert.next = temp.next;
            temp.next = nodeInsert;
            if (temp == tail ){
                tail = nodeInsert;
            }
            size++;
        }
    }

    public Object remove(Object data) {

        Object target = data; // want to remove this data

        Node temp1 = head;
        while (temp1.next != null) { // then check "if" condition / if  "if" condition is false then traverse with else conditon
            if (temp1.next.data == target) {
                temp1.next = temp1.next.next;
                if (temp1.next == tail){
                    tail = temp1;
                }
                // hridoy.next(9) = hridoy.next(9).next(10) // hridoy jump for the (9).next which is (10),and 9 automatic go  for garbage collection
                size--;

            } else {
                temp1 = temp1.next;//Traverse
            }
        }
        return target;

    }

    public Object reverseLs(){

        Node cur = head.next;
        Node prev = null;
        Node temp = null;
        while (cur != null){
             temp = cur.next;
             cur.next = prev;
             prev = cur;
             cur = temp;

        }
        return prev;
    }



    public void printList() {
        Node curr = head;
        while (curr.next != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
}




