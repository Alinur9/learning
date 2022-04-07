public class IntersectionNode {
    ListNode head1 = new ListNode();
    ListNode head2 = new ListNode ();
    public void add1(int data){
        ListNode pointer = new ListNode(data);


        ListNode cur1 = head1;
        while (cur1.next != null){
            cur1 = cur1.next;
        }
        cur1.next = pointer;

    }
    public  void add2(int data ){
        ListNode pointer2 = new ListNode(data);

        ListNode cur2 = head2;

        while (cur2.next!= null){
            cur2 = cur2.next;
        }
        cur2.next = pointer2;

    }
    public ListNode getInterSection(){
       ListNode  temp1= head1;
        ListNode temp2= head2;
        while (temp1!= null && temp2 != null){
            if (temp1 == temp2){
                return temp1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
            if(temp1 == null){
                temp1 = head2;
            }else if (temp2 == null){
                temp2 = head1;
            }
        }
        return  null;
    }
    public  void println(){
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1.next != null){
            System.out.println(temp1.data);
            temp1 = temp1.next;
        }
        System.out.println(temp1.data);
        while (temp2.next != null){
            System.out.println(temp2.data);
            temp2 = temp2.next;
        }
        System.out.println(temp2.data);

    }
}

