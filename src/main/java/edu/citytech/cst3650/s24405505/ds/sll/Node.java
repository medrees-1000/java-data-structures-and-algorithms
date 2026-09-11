package edu.citytech.cst3650.s24405505.ds.sll;

import java.io.Serializable;

public class Node <T extends Comparable<T>> implements Serializable {

    private static final long serialVersionUID = 1L;
 
    private Node<T> next = null;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }
    
    public T getValue() {
        return value;
    }

    // Added to support upsert logic
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
}