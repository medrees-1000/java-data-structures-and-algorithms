package edu.citytech.cst3650.s24405505.ds.bst;


class BSTNode <T extends Comparable<T>> {

    T value;
    BSTNode<T> leftChild;
    BSTNode<T> rightChild;
    int height = 0;

    public BSTNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BSTNode: " + this.value + ", height: " + height;
    }

}
