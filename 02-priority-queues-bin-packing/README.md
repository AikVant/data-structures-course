# Assignment 2: Sorting & Priority Queues - Bin Packing Problem

This project implements an optimization solution for the **Bin Packing Problem**, focusing on efficiently allocating files (folders) of various sizes into storage disks with a fixed capacity of 1TB (1,000,000 MB).

## Part A: Data Structures & Components

### 1. Max-Priority Queue (`MaxPQ`)
A heap-based Priority Queue implemented with **Generics**. 
* **Key Operations:** `insert(T item)` and `getMax()`.
* **Internal Logic:** Uses `shiftUp` (swim) and `shiftDown` (sink) to maintain heap invariants in $O(\log n)$ time.

### 2. Disk Class
Represents a storage unit with a capacity of 1,000,000 MB.
* **Attributes:** Unique `diskId`, `freeSpace`, and a `List` of folders stored within.
* **Comparison:** Implements the `Comparable` interface to allow sorting/ordering based on the remaining free space (used by the Priority Queue).
* **Efficiency:** Maintains an updated `freeSpace` value every time a folder is added.

---

## Part B & C: The Algorithms

Two greedy approaches are implemented and compared:

### Algorithm 1: Simple Greedy (`Greedy.java`)
1. Reads folders from a text file in their original order.
2. For each folder, it retrieves the disk with the **maximum free space** from the `MaxPQ`.
3. If the folder fits, it is placed there, and the disk is re-inserted into the `MaxPQ` with its updated capacity.
4. If it doesn't fit, a new disk is created.

### Algorithm 2: Greedy Decreasing (`Greedy_decreasing.java`)
1. Uses **MergeSort** (implemented in `Sort.java`) to sort all folders in **descending order** (largest to smallest) before processing.
2. Applies the same Greedy logic as Algorithm 1.
3. **Observation:** Sorting the input typically leads to a more efficient distribution, requiring fewer disks overall.

---

## Part D: Performance Comparison & Testing

### Test Generation (`CreateSampleTests`)
Automated generation of 30 test files:
* 10 files with 100 folders each.
* 10 files with 500 folders each.
* 10 files with 1000 folders each.
* Folder sizes are generated randomly between 0 and 1,000,000.

### Experimental Results (Average Number of Disks)
The `CompareAlgorithms` class was used to calculate the mean performance:

| Folders (N) | Algorithm 1 (Greedy) | Algorithm 2 (Greedy Decreasing) |
| :--- | :---: | :---: |
| **100** | 61.2 | 55.3 |
| **500** | 298.8 | 260.3 |
| **1000** | 582.2 | 505.1 |

**Conclusion:** Algorithm 2 (Greedy Decreasing) consistently outperforms Algorithm 1. The efficiency gap widens as the number of folders ($N$) increases, proving that pre-sorting the data is a superior heuristic for the Bin Packing problem.

---

## 🚀 Execution
To run the comparison:
```bash
javac *.java
java CreateSampleTests
java CompareAlgorithms
```
The test files are created by CreateSampleTests class.