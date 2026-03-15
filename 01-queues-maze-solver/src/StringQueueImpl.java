import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl<T> implements StringQueue<T>{
    private Node<T> head = null;
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
        return head == null;
    }

    @Override
    public void put(T item){
        Node<T> temp = new Node<>(item);
        if (head == null){
            tail = temp;
            head = tail;
        } else{
            tail.next = temp;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T get() throws NoSuchElementException{
        if (head != null){
           T item = head.data;
           head = head.next;
           size--;
           return item;
        }
        return null;
    }

    @Override
    public T peek() throws NoSuchElementException{
        if (head != null){
            return this.head.data;
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
        if (isEmpty()) {
            return " List is empty :(";
        }

        Node<T> current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append("\n HEAD -> ");

        while (current != null) {
            ret.append(current.data);

            if (current.next != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }
}
