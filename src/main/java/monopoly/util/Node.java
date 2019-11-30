package monopoly.util;

public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> previous;

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setData(T data) {
        this.data = data;
    }

    //TODO: finish implementation of this


}
