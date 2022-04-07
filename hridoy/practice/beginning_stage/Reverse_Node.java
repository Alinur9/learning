public class Reverse_Node {
 private    Node head1 = new Node("User dont have authorize");
 int size = 0;
    public void add(Object node) {
        Node cur = new Node(node);
        Node temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = cur;
        size ++;
    }

     public Node reverseList(Object data) {
        //1,2,3,4
        Node node = new Node(data);
         if (head1.next != null){
             head1 = head1.next;
         }
         else {
             head1.next = node;
         }
         Node hTemp = head1.next;
       Node prev = null;//head
       while (head1.next != null){
           Node temp = hTemp.next; //3
           hTemp.next = prev; //1-> d
           prev = hTemp;//1
           hTemp = temp;//2
       }
       return  prev;

            }
    public void printNode(){
        Node res = head1;
        while (res.next != null){
            System.out.println(res.data);
            res = res.next;

        }

    }

    public Object reverseList() {
        return null;
    }
}