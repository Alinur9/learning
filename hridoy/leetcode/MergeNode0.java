package leetcode.com.company;
public class MergeNode0 {

    Node head ;
   int size;

     public void add(int data){
         Node newNode =  new Node(data);
         if (head == null){
             head = newNode;
             size++;
         }else{
             Node curr = head;
             while(curr.next!=null){
                 curr =curr.next;
             }
             curr.next = newNode;
             size++;
         }
     }
     public  Node margeNode(Node head){
         if (head == null || head.next == null) return null;

         Node headRef = head;
         Node headnxtRef = head.next;
         while (headnxtRef != null) {
             int sum = 0;
             while (headnxtRef.data != 0) {
                 sum = sum + headnxtRef.data;
                 headnxtRef = headnxtRef.next;
             }
                 headnxtRef.data = sum;

                 headRef.next =headnxtRef;
                headRef = headRef.next;
                headnxtRef = headnxtRef.next;
         }
         return head.next;
             }






     void print(){
         Node current = head;
         while(current.next != null){
             System.out.println(current.next.data);
             current = current.next;
         }
     }
}
