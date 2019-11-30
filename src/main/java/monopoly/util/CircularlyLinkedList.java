package monopoly.util;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CircularlyLinkedList<T> implements Iterable<T> {
    private Node<T> head; //GO
    private Node<T> tail; //Boardwalk/Last blue property

    //Default constructor for CircularlyLinkedList
    public CircularlyLinkedList() {
        head = null;
        tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public void add(Node<T> tile) {
        //Adds tiles into the circularly linked list
        //Check if head node is empty
        if (head == null) {
            head = tile; //Sets tile to be new head
        } else {
            //Start from head node and iterate down
            Node<T> curr = head;
            //Iterate to last node in list - Testing something
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            //Else, if next node is empty, connect
            //Else, check if tail is null
            curr.setNext(tile);
            //Retrieve the added node & set up to become tail
            curr.getNext().setNext(null);
            curr.getNext().setPrevious(curr);
            //Check if tail is null
            //Set node to be tail
            tail = curr.getNext();
        }
    }

    //Iterator method
    @Override
    public ListIterator<T> iterator() {
        return new CircularlyLinkedListIterator(this);
    }

    //iterator internal class
    class CircularlyLinkedListIterator implements ListIterator<T>{
        Node<T> current; //Tracks current node iterator is on
        public CircularlyLinkedListIterator(CircularlyLinkedList<T> list){
            //Default constructor - Sets current position to head
            current = list.getHead();
        }
        @Override
        //Checks current node's next node if it is head or not for looping purposes
        public boolean hasNext() {
            return current.getNext() != head;
            //return current != null;
        } //altered to work with a circularly linked list

        @Override
        public T next() {
            T data = current.getData(); //Retrieves data from node
            current = current.getNext(); //update iterator
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        public T previous(){
            T data = current.getData(); //Retrieves data from node
            current = current.getPrevious(); //updates iterator
            return data;
        }

        //These next commands do nothing but are necessary to override list iterator for ListIterator implementation
        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }
    //TODO: implement this


}
