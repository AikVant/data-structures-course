public class List<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    int size = 0;
    private static class Node<T>{
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return this.data;
        }
    }
    public List(){

    }
    public boolean isEmpty(){
        return head == null;
    }
    int getSize(){
        return this.size;
    }
    public void insertAtFront(T data){
        Node<T> node = new Node<>(data);
        if (isEmpty()){
            head = node;
            tail = node;
        }else
            node.next = head;
        head = node;
        size++;
    }

    public void insertAtBack(T data){
        Node<T> node = new Node<>(data);
        if (isEmpty()){
            head = node;
        }else
            tail.next = node;
        tail = node;
        size++;

    }
    public T removeFromFront() throws NullPointerException{
        if (isEmpty()) {
            System.out.println("List is empty:(");
            return null;
            //throw new NullPointerException();
        }
        T data = head.data;
        if (head == tail)
            head = tail = null;
        else
            head = head.next;
        size--;
        return data;
    }

    public T removeFromBack() throws NullPointerException{
        if (isEmpty()) {
            System.out.println("List is empty:(");
            return null;
            //throw new NullPointerException();
        }
        T data = tail.data;
        if (head == tail)
            head = tail = null;
        else{
            Node<T> current = head;
            while (current.next != tail)
                current = current.next;
            current.next = null;
            tail = current;
        }
        size--;
        return data;
    }

    public T getFrontData(){
        if (isEmpty()) {
            System.out.println("List is empty:(");
            return null;
            //throw new NullPointerException();
        }
        return head.data;
    }

    public T getBackData(){
        if (isEmpty()) {
            System.out.println("List is empty:(");
            return null;
            //throw new NullPointerException();
        }
        return tail.data;
    }

    public String toString(){
        if (isEmpty()){
            return "List is empty:(";
        }
        Node<T> current = head;
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        while (current != null){
            ret.append(current.getData());
            if (current.next != null)
                ret.append(",");
            current = current.next;
        }
        ret.append("]");
        return ret.toString();
    }
}
