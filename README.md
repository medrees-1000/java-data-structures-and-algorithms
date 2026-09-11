# Java-data-structures-and-algorithms: Custom Data Structures and Algorithms in Java

A modular Java implementation of foundational data structures, self-balancing search trees, search and sort algorithms, and flexible hash-table collision strategies. All components feature explicit algorithmic operation tracking via custom container types.

Repository: https://github.com/medrees-1000/java-data-structures-and-algorithms

---

## Project Structure

The project is organized into modular packages based on abstract data type categories:

* `edu.citytech.cst3650.s24405505.ds.array`: Array utilities and dynamic array implementations.
* `edu.citytech.cst3650.s24405505.ds.sll`: Singly linked list and node definitions.
* `edu.citytech.cst3650.s24405505.ds.bst`: Binary search trees, AVL self-balancing trees, and rotation helpers.
* `edu.citytech.cst3650.s24405505.ds.dictionary`: Hash map abstractions and multi-strategy collision resolution buckets.
* `edu.citytech.cst3650.s24405505.ds.sort`: Classic searching and sorting algorithms.
* `edu.citytech.cst3650.ds.array`: JUnit 5 test suites validating array behaviors and edge cases.

---

## Key Components

### 1. Linear Data Structures
* **`DynamicArray<T>`**: Resizable generic array with automatic capacity allocation, index insertion, mass conditional deletion via `Predicate<T>`, and aggregate calculations (`min`, `max`, `sum`, `average`).
* **`SortedDynamicArray<T>`**: Extends `DynamicArray` to enforce sorted ordering on insertion, providing constant-time (`O(1)`) min/max queries and logarithmic (`O(log n)`) binary search lookups.
* **`SinglyLinkedList<T>`**: Pointer-based list with direct head and tail tracking, node-level index manipulation, predicate-driven removals, and in-place value updates.
* **`ArrayUtil`**: Utility class handling array reallocation, sub-array slicing, index-based splicing, and bulk removals.

### 2. Binary Search Trees & AVL Balancing
* **`BST<T>`**: Binary Search Tree supporting recursive traversals (in-order, pre-order), height calculations, and tree-wide aggregations. Enforces unique entries via `DuplicateEntryException` or update-in-place via `upsert`.
* **`AVLTree<T>`**: Height-balanced binary search tree that evaluates balance factors on each insertion. It automatically performs single (left, right) or double (left-right, right-left) rotations to maintain an `O(log n)` height bound.
* **`NodeHelper`**: Utility that computes balance factors and manages node pointer swaps during tree rebalancing.

### 3. Hash Dictionaries & Collision Resolution
* **`AdvanceDictionary<K, V>`**: Generic hash map using modulo hashing over an array of buckets.
* **`Bucket<K, V>`**: A flexible collision-handling container capable of swapping its internal collision-resolution structure dynamically via `DataTypeMode`:
  * Singly Linked List
  * Dynamic Array
  * Sorted Dynamic Array
  * Binary Search Tree (BST)
  * Self-Balancing AVL Tree
* **`SimpleDictionary<K, V>`**: Direct-mapped hash table demonstrating basic hashing and collision detection callbacks.

### 4. Algorithms
* **`BinarySearch`**: Standard and size-bounded binary search implementations supporting indexed callbacks via `BiConsumer`.
* **`SelectionSort`**: Iterative comparison sort tracking exact comparison and swap counts.

---

## Unit Testing

The repository contains test suites under JUnit 5 to verify structural integrity and edge bounds:

* **`T1_Array`**: Verifies dynamic array expansion and bounds checking.
* **`T2_ArrayCopyFrom`**: Tests ranged sub-array extraction and boundary index copies.
* **`T3_ArrayRemoveIndexes`**: Validates multi-index bulk element deletions and array compression.
* **`T4_ArraySlice`**: Validates positive and negative slicing indices, length clamping, and edge cases.

---

## Technical Specifications

* **Language**: Java 17+
* **Unit Testing**: JUnit 5
* **IDE**: Eclipse IDE / Compatible with any standard Java build system
* **Design Concepts**: Java Generics, Functional Interfaces (`Predicate`, `Consumer`, `BiConsumer`), Polymorphism, and Strategy Pattern.

---

## Setup and Running

1. Clone the repository:
   ```bash
   git clone [https://github.com/medrees-1000/java-data-structures-and-algorithms.git](https://github.com/medrees-1000/java-data-structures-and-algorithms.git)
