package edu.citytech.cst3650.s24405505.ds.bst;

import java.util.concurrent.atomic.AtomicInteger;

class NodeHelper {
    
    static <T extends Comparable<T>> int calculateBalanceFactor(BSTNode<T> node, AtomicInteger aiOperationCount) {
        aiOperationCount.incrementAndGet();
        if (node == null) return 0;
        
        int leftheight = calculateheight(node.leftChild, aiOperationCount);
        int rightheight = calculateheight(node.rightChild, aiOperationCount);

        // FIXED: Return the actual calculated balance factor instead of hardcoded 0
        return leftheight - rightheight;
    }
    
    static <T extends Comparable<T>> boolean isRightHeavy(BSTNode<T> node, AtomicInteger aiOperationCount) {
        int balanceFactor = calculateBalanceFactor(node, aiOperationCount);
        boolean status = balanceFactor < -1;
        return status;
    }
    
    static <T extends Comparable<T>> boolean isLeftHeavy(BSTNode<T> node, AtomicInteger aiOperationCount) {
        int balanceFactor = calculateBalanceFactor(node, aiOperationCount);
        boolean status = balanceFactor > 1;
        return status;
    }

    static <T extends Comparable<T>> BSTNode<T> rotateLeft(BSTNode<T> node, AtomicInteger aiOperationCount) {
        BSTNode<T> newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        
        setHeight(node, aiOperationCount);
        setHeight(newRoot, aiOperationCount);
        
        aiOperationCount.addAndGet(3);
        return newRoot;
    }
    
    static <T extends Comparable<T>> BSTNode<T> rotateRight(BSTNode<T> node, AtomicInteger aiOperationCount) {
        aiOperationCount.addAndGet(5);
        
        BSTNode<T> newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        
        setHeight(node, aiOperationCount);
        setHeight(newRoot, aiOperationCount);
        
        return newRoot;
    }

    static <T extends Comparable<T>> int setHeight(BSTNode<T> node, AtomicInteger aiOperationCount) {
        aiOperationCount.addAndGet(3);
        double heightL = calculateheight(node.leftChild, aiOperationCount);
        double heightR = calculateheight(node.rightChild, aiOperationCount);
        
        int calculatedHeight = (int)(1 + Math.max(heightL, heightR));
        return calculatedHeight;
    }

    static <T extends Comparable<T>> int calculateheight(BSTNode<T> node, AtomicInteger aiOperationCount) {
        aiOperationCount.addAndGet(2);
        
        if (node == null) return -1;
        
        boolean isLeaf = node.leftChild == null && node.rightChild == null;
        
        if (isLeaf) {
            node.height = 0;
            return 0;
        }
        
        int calculatedHeight = setHeight(node, aiOperationCount);
        node.height = calculatedHeight;
        return calculatedHeight;
    }
}