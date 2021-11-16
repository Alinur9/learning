public class DoublyNode<T> {
    DoublyNode<T> previous;
    DoublyNode<T> next;
    T t;
    T data;
    T key;
    T value;
    int index = 0;
    public  DoublyNode(T data){
        this.data = data;
    }
    public  DoublyNode(T key , T value){
        this.value = value;
        this.key = key;
        index++;
    }
    public void setPrevious(DoublyNode<T> previous) {
        this.previous = previous;
    }

    public DoublyNode<T> getPrevious() {
        return previous;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    public DoublyNode<T> getNext() {
        return next;
    }
    public T getData() {
        return data;
    }
}

