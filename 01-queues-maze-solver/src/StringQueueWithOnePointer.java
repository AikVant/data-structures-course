import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueWithOnePointer<T> implements StringQueue<T>{
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T>{
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void put(T item) {
        Node<T> temp = new Node<>(item);
        if (isEmpty()) {
            tail = temp;
            temp.next = tail;
        } else {
            temp.next = tail.next;
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    @Override
    public T get() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (tail != null){
            T item = (T) tail.next.data;
            tail.next = tail.next.next;
            size--;
            return item;
        }
        return null;
    }

    @Override
    public T peek() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (tail != null){
            return (T) this.tail.next.data;
        }
        return null;
    }

    @Override
    public void printQueue(PrintStream stream){
        stream.println(this);
    }

    @Override
    public int size(){
        return this.size;
    }

    public String toString(){
        StringBuilder s = new StringBuilder(" ");
        if (isEmpty()){
            return " List is empty :(";
        }
        Node<T> current = tail.next;
        while (current != tail){
            s.append(" -> ").append(current.data);
            current = current.next;
        }

        s.append(" -> ").append(current.data);
        return s + " <- TAIL";
    }
}
