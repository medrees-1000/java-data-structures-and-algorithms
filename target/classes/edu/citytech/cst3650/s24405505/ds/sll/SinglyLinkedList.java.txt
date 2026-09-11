package edu.citytech.cst3650.s24405505.ds.sll;

import com.learning.framework.Instantiate;
import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;
import java.util.function.Predicate;

public class SinglyLinkedList<T extends Comparable<T>> extends ConceptualList<T> {

    private static final long serialVersionUID = 1L;

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public SinglyLinkedList(Instantiate<T[]> intFunction) {
        // Constructor matches existing framework pattern
    }

    @Override
    public Result append(T value) {
        int operationCount = 0;
        var newNode = new Node<T>(value);
        operationCount++;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (size == 1) {
            head.setNext(newNode);
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        this.size++;
        return new Result(operationCount, size, true, "Success!");
    }

    @Override
    public Result append(@SuppressWarnings("unchecked") T... value) {
        int operationCount = 0;
        for (T t : value) {
            var result = this.append(t);
            operationCount += result.operationCount;
        }
        return new Result(operationCount, size, true, "Success!");
    }

    @Override
    public Result length() {
        return new Result(1, this.size, true, "Success!");
    }

    private Pair<Result, Node<T>> getNodeAt(int index) {
        int operationCount = 0;

        if (index < 0) {
            return new Pair<>(new Result(1, this.size, true, "Success"), this.head);
        }

        if (index == 0) {
            operationCount++;
            return new Pair<>(new Result(operationCount, this.size, true, "Success"), this.head);
        }

        Node<T> currentNode = head.getNext();
        for (int i = 1; i < index; i++) {
            operationCount++;
            if (currentNode != null) {
                currentNode = currentNode.getNext();
            }
        }

        return new Pair<>(new Result(operationCount, this.size, true, "Success"), currentNode);
    }

    @Override
    public T get(int index) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index: " + index);
        }
        var pair = getNodeAt(index);
        return pair.item2.getValue();
    }

    @Override
    public Result removeLast() {
        if (size <= 1) {
            return removeFirst();
        }
        int index = size - 2;
        var pair = this.getNodeAt(index);
        Node<T> nextToLastNode = pair.item2;
        nextToLastNode.setNext(null);
        this.tail = nextToLastNode;
        this.size--;
        return pair.item1;
    }

    @Override
    public Result removeFirst() {
        if (this.head == null || this.size == 0) {
            return new Result(1, size, true, "Success! But No Data");
        }
        Node<T> nextNode = this.head.getNext();
        this.head = nextNode;
        size--;
        if (size == 0) tail = null;
        return new Result(1, size, true, "Successfully Removed");
    }

    @Override
    public Result removeByIndex(int index) {
        if (index == 0) return this.removeFirst();

        Node<T> prev = this.getNodeAt(index - 1).item2;
        Node<T> target = prev.getNext();
        Node<T> nextNode = target.getNext();
        
        prev.setNext(nextNode);
        if (nextNode == null) {
            this.tail = prev;
        }
        this.size--;
        return new Result(1, size, true, "Success");
    }

    // --- NEW METHODS ---

    @Override
    public Result insertAt(T value, int index) {
        if (index < 0 || index > this.size) {
            return new Result(1, size, false, "Index out of bounds");
        }

        if (index == 0) {
            Node<T> newNode = new Node<>(value);
            newNode.setNext(head);
            head = newNode;
            if (size == 0) tail = newNode;
            size++;
            return new Result(1, size, true, "Success");
        }

        var pair = getNodeAt(index - 1);
        Node<T> prev = pair.item2;
        Node<T> newNode = new Node<>(value);
        
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        
        if (newNode.getNext() == null) tail = newNode;
        size++;

        return new Result(pair.item1.operationCount + 1, size, true, "Success");
    }

//    @Override
//    public Result upsert(T value) {
//        int operationCount = 0;
//        Node<T> current = head;
//        
//        while (current != null) {
//            operationCount++;
//            if (current.getValue().compareTo(value) == 0) {
//                current.setValue(value); // Update existing
//                return new Result(operationCount, size, true, "Updated existing item");
//            }
//            current = current.getNext();
//        }
//
//        Result appendResult = this.append(value); // Insert new if not found
//        return new Result(operationCount + appendResult.operationCount, size, true, "Inserted new item");
//    }

    @Override
    public Result removeAll(Predicate<T> filter) {
        if (filter == null) {
            int ops = size;
            head = null;
            tail = null;
            size = 0;
            return new Result(ops, 0, true, "All items removed");
        }

        int operationCount = 0;
        // Using a while loop to handle consecutive removals correctly
        Node<T> dummy = new Node<>(null); 
        dummy.setNext(head);
        Node<T> current = dummy;

        while (current.getNext() != null) {
            operationCount++;
            if (filter.test(current.getNext().getValue())) {
                current.setNext(current.getNext().getNext());
                size--;
            } else {
                current = current.getNext();
            }
        }
        
        head = dummy.getNext();
        // Update tail
        Node<T> temp = head;
        while (temp != null && temp.getNext() != null) temp = temp.getNext();
        tail = temp;

        return new Result(operationCount, size, true, "Filtered removal complete");
    }
    
    @Override
    public String toString() {

        Node<T> currentNode = this.head;
        StringBuilder sb = new StringBuilder();

        int pseudoIndex = 0;

        // Appends the class name and current size as a header
        sb.append(this.getClass().getSimpleName());
        sb.append(" size: ");
        sb.append(this.size);
        sb.append(" ");

        while (currentNode != null) {

            sb.append(currentNode.getValue());
            sb.append("(");
            sb.append(pseudoIndex++);
            sb.append(")");

            currentNode = currentNode.getNext();
            if (currentNode != null) {
                sb.append(" --> ");
            }
        }

        return sb.toString();
    }
    
    @Override
    public Result upsert(T value) {
        int operationCount = 0;
        Node<T> current = this.head;
        boolean found = false;
        while (current != null) {
            operationCount++;
            // If compareTo returns 0, the "keys" match
            if (current.getValue().compareTo(value) == 0) {
                current.setValue(value); // Update existing data
                found = true;
                break; // Stop searching once found
            }
            current = current.getNext();
        }

        if (!found) {
            Result appendResult = this.append(value);
            // Total work = search cost + insertion cost
            return new Result(operationCount + appendResult.operationCount, this.size, true, "Success");
        }
        return new Result(operationCount, this.size, true, "Success");
    }
    
    @Override
    public Pair<Result, T> findOne(T value) {
        var currentNode = head;
        int operationCount = 0;

        while (currentNode != null) {
            operationCount++;

            if (currentNode.getValue() != null) {
                int status = currentNode.getValue().compareTo(value);
                
                if (status == 0) {
                    var result = new Result(operationCount, this.size, true, "Success");
                    return new Pair<>(result, currentNode.getValue());
                }
            }            
            currentNode = currentNode.getNext();
        }
        var failResult = new Result(operationCount, this.size, false, "Item not found");
        return new Pair<>(failResult, null);
    }

}
