# Data Structures - Athens University of Economics and Business (AUEB)

This repository contains a collection of assignments developed for the **Data Structures** course at the Athens University of Economics and Business (AUEB), Winter Semester 2022.

## Projects Overview

### 01. Queues: ADT Implementations & Maze Solver
**Directory:** `01-queues-maze-solver`

* **Part A & C (ADT Implementations):** Implementation of **Stack** and **FIFO Queue** Abstract Data Types using singly linked lists[cite: 487, 490]. [cite_start]The operations (push, pop, put, get, size) are optimized for $O(1)$ time complexity[cite: 491, 492]. 
* **Part B (Application):** A maze-solving client that uses the Stack implementation to navigate through a 2D grid ($n \times m$) and find the exit[cite: 503, 504].
* **Keywords:** Singly Linked List, Generics, Maze Navigation, Stack/Queue ADT.

### 02. Sorting & Priority Queues: Bin Packing Problem
**Directory:** `02-priority-queues-bin-packing`

* **Concept:** Implementation of the **Bin Packing** problem, an optimization challenge focused on resource allocation (e.g., storing folders into 1TB disks)[cite: 676, 680].
* **Algorithms:** 
  * **Greedy Algorithm:** Processes folders in their given order and places them in the disk with the most available space using a Max-Priority Queue[cite: 703, 704].
  * **Decreasing Greedy:** Sorts folders in descending order before processing to achieve a more optimal number of disks[cite: 601, 602].
* **Data Structures:** Max-Priority Queue (MaxPQ) based on a Heap, Comparable Interface for Disk objects.
* **Keywords:** Priority Queue, Heaps, Greedy Algorithms, Optimization, Bin Packing.

### 03. Binary Search Trees: 2D-Trees Implementation
**Directory:** `03-binary-search-trees-2d`

* **Concept:** Implementation of **2d-trees**, a space-partitioning data structure for organizing points in a 2-dimensional space.
* **Key Functionalities:**
    * **Range Search:** Efficiently finds all points contained within a given query rectangle[cite: 917].
    * **Nearest Neighbor Search:** Finds the point in the tree closest to a specific query point[cite: 918].
* **Applications:** Collision detection in 2D spatial data processing.
* **Keywords:** 2d-trees, Binary Search Trees, Spatial Data, Range Search, Nearest Neighbor.

---

## Technologies & Tools
* **Language:** Java
* **IDE:** IntelliJ IDEA / VS Code
* **Version Control:** Git & GitHub

## Structure
Each folder contains:
* `src/`: The Java source files.
* `report.pdf`: A brief technical report explaining the implementation details and complexity analysis.
* Input files (`.txt`) for testing.

## How to Run
To compile and run any project (e.g., Assignment 1), navigate to the folder and use:
```bash
javac *.java
java MainClassName input.txt
```
Replace MainClassName with the class containing the main method as specified in each assignment's instructions.