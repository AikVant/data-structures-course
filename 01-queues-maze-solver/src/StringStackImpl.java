import java.io.PrintStream;
// import java.lang.reflect.Type;
import java.util.NoSuchElementException;

public class StringStackImpl<T> implements StringStack<T> {
    private Node<T> top;
    private int size;
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
        return top == null;
    }
    @Override
    public void push(T item){
        Node<T> current = new Node<>(item);
        current.next = top;
        top = current;
        size++;
    }
    @Override
    public T pop() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T result = top.data;
        top = top.next;
        size--;
        return result;
    }
    @Override
    public T peek() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return top.data;
    }
    @Override
    public void printStack(PrintStream stream){
        stream.println(this);
    }
    @Override
    public int size(){
        return size;
    }

    public String toString(){
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node<T> current = top;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append("\n\nTOP -> ");

        while (current != null) {
            ret.append(current.data);

            if (current.next != null)
                ret.append(" -> ");

            current = current.next;
        }
        return ret.toString();
    }
}
