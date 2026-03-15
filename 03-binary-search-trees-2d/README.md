# Assignment 3: Binary Search Trees - 2d-Trees Implementation

This project implements a **2d-tree**, a specialized data structure for organizing points in a 2-dimensional space. It enables efficient spatial queries such as searching for points within a rectangular area and finding the nearest neighbor to a given point.

## Part A: Geometric Primitives
The foundation of the project rests on two core classes:

### 1. Point Class
Represents a point $(x, y)$ in the 2D plane. Includes methods for calculating Euclidean and squared distances between points.

### 2. Rectangle Class
Represents an axis-aligned rectangle defined by its boundaries $(xmin, xmax, ymin, ymax)$.
* **`contains(Point p)`**: Checks if a point lies within the rectangle's bounds.
* **`intersects(Rectangle other)`**: Determines if two rectangles overlap by comparing their min/max coordinates.
* **`distanceTo(Point p)`**: Calculates the shortest distance from a point to the rectangle's closest edge or corner.

---

## Part B: 2d-Tree Implementation
The `TwoDTree` class manages the spatial partitioning using an internal `TreeNode` class. Each node at an **even level** splits the plane vertically (based on x-coordinate), while each node at an **odd level** splits the plane horizontally (based on y-coordinate).

### 1. Nearest Neighbor Search (`nearestNeighbor`)
Finds the point in the tree closest to a target point using an optimized recursive search:
* **Best-side First**: The algorithm first explores the subtree that is more likely to contain the nearest neighbor based on the target point's position relative to the splitting line.
* **Pruning**: It calculates the distance from the target point to the rectangle representing the "worst-side" subtree. If this distance is greater than the current minimum distance found, the entire subtree is pruned (skipped), significantly improving performance.

### 2. Range Search (`rangeSearch`)
Identifies all points within a query rectangle.
* **Logic**: Uses a recursive traversal (`rangeSearchR`). If a node's point is contained in the rectangle, it is added to a Result Queue. 
* **Optimization**: The search only proceeds to subtrees whose corresponding rectangles intersect with the query rectangle.

---

## Project Structure
* **`TwoDTree`**: The main data structure containing the spatial logic.
* **`TreeNode`**: Private inner class representing nodes and their associated bounding rectangles.
* **`FunctionsOfMenu`**: Static utility class coordinating file I/O and menu operations.
* **`Menu / Main`**: The user interface for interacting with the tree (inserting points, performing searches).

## Explanatory Figures
[**Figure 1:**](images/Point-Rectangle-relation.svg) Point-in-Rectangle test. Checking if a point p(x,y) lies within the [xmin,xmax] and [ymin,ymax] boundaries.

[**Figure 2:**](images/Rectangles_relation.svg) Rectangle Intersection logic. Two rectangles do not intersect if one's maximum bound is less than the other's minimum bound on either axis.

[**Figure 3:**](images/2d_tree_rectangles.svg) Spatial partitioning in a 2d-tree. Each node divides its parent's rectangle into two smaller rectangles (left/right or top/bottom) based on the current level.

## Execution
To run the 2d-tree application:
```bash
javac *.java
java Main input_points.txt
```
