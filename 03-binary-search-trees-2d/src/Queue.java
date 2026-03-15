import java.io.PrintStream;
import java.util.NoSuchElementException;
public class Queue<T> {
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

    public boolean isEmpty(){
        return head == null;
    }

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

    public T get() throws NoSuchElementException{
        if (head != null){
            T item = head.data;
            head = head.next;
            size--;
            return item;
        }
        return null;
    }


    public T peek() throws NoSuchElementException{
        if (head != null){
            return this.head.data;
        }
        return null;
    }


    public void printQueue(PrintStream stream){
        stream.println(this);
    }

    public int size(){
        return this.size;
    }

    public String toString(){
        if (isEmpty()) {
            return " There are no tree points contained in the specified rectangle.";
        }

        Node<T> current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append(" [");

        while (current != null) {
            ret.append(current.data);

            if (current.next != null)
                ret.append(", ");

            current = current.next;
        }

        ret.append("]");

        return ret.toString();
    }
}
