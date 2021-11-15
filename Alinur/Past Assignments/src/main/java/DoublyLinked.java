public class DoublyLinked <E> {
    public E e;
    public int addCount = 0;
    private DoublyNode<E> x1 = new DoublyNode("Head");
    private DoublyNode<E> x10 = new DoublyNode("Tail");
    private DoublyNode<E> x3 = new DoublyNode("Engine");
    public <E> DoublyLinked(){

    }
    public void add(DoublyNode<E> x2){

        if (addCount == 0){
            x1.next = x2;
            x2.previous = x1;
        }else {
            x3.next = x2;
            x2.previous = x3;
            x2.next = x10;
            x10.previous = x2;
        }
        x3 = x2;
        addCount++;
    }
    public DoublyNode head(){
        return x1.next;
    }
    public DoublyNode tail(){
        return x10.previous;
    }
    public DoublyNode get(int index){
        DoublyNode n = new DoublyNode("Initialize");
        if (index > addCount/2){
             n = x10;
            for (int i = addCount; i > index  ; i--) {
                n =  n.previous;
            }
        }else {
             n = x1;
            for (int i = 0; i < index+1; i++) {
                 n = n.next;
            }
        }
        return n;
    }
    public void update(DoublyNode node){
        System.out.println(addCount);
        System.out.println(node.index);
        remove(node.index);
        add(node);
    }
    public void remove(int index){
        DoublyNode n = get(index);
        if (index == addCount- 1){
            DoublyNode previousN = n.previous;
            n.previous = null;
            previousN.next = x10;
            x10.previous = previousN;

        } else if (addCount > index && index > 0 && addCount != index -1){
            DoublyNode previousN = n.previous;
            DoublyNode nextN = n.next;
            n.previous = null;
            n.next  = null;
            previousN.next = nextN;
            nextN.previous = previousN;
        }else if (index == 0){
            DoublyNode nextN = n.next;
            n.next = null;
            x1.next = nextN;
            nextN.previous = x1;
        }

        addCount--;
    }
}
