# Assignment 1: Queues, Stacks & Maze Solver

This project focuses on the implementation of fundamental Abstract Data Types (ADTs) and their application in solving a pathfinding problem in a 2D maze.

## Part A: ADT Implementations (Generics)
Both Stack and Queue implementations use **Java Generics** to ensure type safety and flexibility.

### 1. StringStackImpl
An implementation of a Stack using a singly linked list.
* **Structure:** Uses an internal private `Node` class and maintains a `top` reference and an `int size`.
* **Performance:** The methods `push()`, `pop()`, `peek()`, and `isEmpty()` all operate in **O(1)** time complexity.

### 2. StringQueueImpl
An implementation of a FIFO Queue using a singly linked list.
* **Structure:** Maintains `head` and `tail` references for efficient access to both ends, along with an `int size`.
* **Performance:** The methods `put()`, `get()`, `peek()`, and `isEmpty()` operate in **O(1)** time complexity.

---

## Part C: Circular Queue with a Single Pointer
### StringQueueWithOnePointer
A specialized implementation of a Queue that uses **only one pointer** (`tail`) by forming a **Circular Linked List**.

* **Logic:** The `next` field of the last node (tail) points back to the first node (head) of the queue.
* **Empty State:** The `tail` reference is `null` only when the queue is initialized. Once an element is added, `tail` is never `null` again; instead, the `size` variable is used to determine if the queue is empty (`size == 0`).
* **Operations:**
    * **Enqueuing:** When a new node is added, it is inserted after the tail, and the tail pointer is updated to this new node.
    * **Dequeuing:** The pointer simply moves to the next node in the circle.
    * **Traversal (toString):** The queue is traversed starting from the head until the pointer returns to the `tail` reference.

---

## Part B: Maze Solver (Thiseas)
The application `Thiseas` simulates a pathfinding algorithm to find an exit in a grid-based maze.

### Workflow:
1.  **Input:** The program accepts a `.txt` file via command-line arguments.
2.  **Maze Initialization:** The `Maze` class reads the file, stores the grid in a 2D character array, and validates the input (including support for the Greek character 'Ε' as an entry point).
3.  **Solver Logic:** * The `MazeSolver` class initializes a `StringStackImpl` to keep track of the path.
    * The `traverse()` method coordinates the search. It pops the current position and uses `tryPosition()` to mark it as visited.
    * Valid neighboring moves (cells with value `0`) are identified via `pushNewPos()` and pushed onto the stack.
    * Coordinates are stored as `Strings` in the stack and converted back to `integers` for grid manipulation.
4.  **Termination:** The process continues until the `solved()` method detects that the current position is on the boundaries of the grid (exit found) or the stack becomes empty (no path exists).
5.  **Output:** The program prints the exit coordinates (if found) and the final grid state, showing the cells that were explored during the process.

## 🚀 Execution
To compile and run the Maze Solver:
```bash
cd src
javac *.java
java Thiseas maze.txt
```