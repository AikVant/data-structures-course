import java.util.Comparator;

public class MaxPQ<T> {
    private T[] heap;
    private int size = 0; // size of the priority queue
    private final Comparator<T> comparator;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int AUTOGROW_SIZE = 10;

    /**
     * constructor
     * the first (zero) position is empty
     * That's why the first length of heap is DEFAULT_CAPACITY + 1
     */
    public MaxPQ(Comparator<T> comparator) {
        this.heap = (T[]) new Object[DEFAULT_CAPACITY + 1];
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }
    /**
     * returns the max element in the priority queue
     */
    public T peek() {
        if (size == 0)
            return null;
        return heap[1]; // the first max element in the priority queue
    }

    /**
     * @param item
     * inserts the specified element into the priority queue
     * Uses shiftUp
     */
    public void insert(T item){
        if (size == heap.length - 1) // we don't have the first (zero) position
            grow();
        size++;
        heap[size] = item;
        shiftUp(size); // calls the shiftDown to preserve the property of the priority queue
    }

    /**
     * @param childIndex of current child
     * compares priorities of current child and parent elements
     * and swap the elements while child's priority is higher than parent's priority
     */
    public void shiftUp(int childIndex){
        if (childIndex == 1)
            return;
        int parent = childIndex / 2;
        while (childIndex != 1 && comparator.compare(heap[childIndex], heap[parent]) > 0){
            swap(childIndex, parent);
            childIndex = parent; 		// update childIndex
            parent = childIndex / 2; 	// update parent
        }
    }

    /**
     * removes and returns the max element in the priority queue
     * Uses shiftDown
     */
    public T getMax(){
        if (size == 0)
            return null;
        T root = heap[1]; // keep the reference of the max element
        heap[1] = heap[size]; // put the last element into the first index
        size--;
        shiftDown(1); // calls the shiftUp to preserve the property of the priority queue
        return root;
    }

    /**
     * @param parentIndex of current parent
     * compares priorities of current left and right children to find max_child
     * compares priorities of max_child and current parent
     * and swap the parent with max_child if parent < max_child
     */
    public void shiftDown(int parentIndex){
        int left = 2 * parentIndex;
        int right = left + 1;

        if (left > size) // if left child is greater than size means there is no other element in the priority queue
            return;
        while(left <= size){
            int max_child = left;
            if (right <= size){
                if (comparator.compare(heap[left], heap[right] ) < 0)
                    max_child = right;
            }
            if (comparator.compare(heap[parentIndex], heap[max_child]) >= 0)
                return;
            else{
                swap(parentIndex, max_child);
                parentIndex = max_child;
                left = 2 * parentIndex; // update left's index
                right = left + 1; // update right's index
            }
        }
    }

    /**
     * @param i, j
     * swaps elements in positions i, j
     */
    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    /**
     * Helper function to grow the size of the heap
     */
    private void grow() {
        T[] newHeap = (T[]) new Object[heap.length + AUTOGROW_SIZE];

        // copy array
        System.arraycopy(heap, 1, newHeap, 1, size);

        heap = newHeap;
    }

    public T[] getHeap(){
        return this.heap;
    }

    public String toString(){
        if (isEmpty()){
            return "heap is empty:(";
        }
        StringBuilder s = new StringBuilder("[");
        for (int i = 1; i < size; i++){
            s.append(heap[i]).append(",");
        }
        s.append(heap[size]).append("]");
        return s.toString();
    }
}
