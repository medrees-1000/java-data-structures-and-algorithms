package edu.citytech.cst3650.s24405505.ds.bst;

import java.util.concurrent.atomic.AtomicInteger;
import static edu.citytech.cst3650.s24405505.ds.bst.NodeHelper.*;
import com.learning.framework.Instantiate;
import com.learning.framework.dto.Result;

public class AVLTree<T extends Comparable<T>> extends BST<T> {

    private static final long serialVersionUID = 1L;

    public AVLTree(Instantiate<T[]> intFunction) {
        super(intFunction);
    }

    @Override
    public Result append(T value) {
        AtomicInteger aiOperationCount = new AtomicInteger(1);
        super.root = this.append(root, value, aiOperationCount);
        
        return new Result(aiOperationCount.get(), super.size, true, "Success");
    }

    // FIXED: Added missing upsert overrides so dictionary insertion triggers AVL code
    @Override
    public Result upsert(T value) {
        AtomicInteger aiOperationCount = new AtomicInteger(1);
        super.root = this.append(super.root, value, aiOperationCount);
        return new Result(aiOperationCount.get(), super.size, true, "Success");
    }

    public Result upsert(@SuppressWarnings("unchecked") T... value) {
        int operationCount = 0;
        for (T t : value) {
            var result = this.upsert(t);
            operationCount += result.operationCount;
        }
        return new Result(operationCount, super.size, true, "Success");
    }

    private BSTNode<T> append(BSTNode<T> node, T value, AtomicInteger aiOperationCount) {
        aiOperationCount.incrementAndGet();

        // Base Code
        if (node == null) {
            super.size++;
            return new BSTNode<T>(value);
        }

        int status = value.compareTo(node.value);

        if (status < 0) {
            node.leftChild = append(node.leftChild, value, aiOperationCount);
        } else if (status > 0) {
            node.rightChild = append(node.rightChild, value, aiOperationCount);
        } else if (status == 0) {
            // Upsert requirement: overwrite current node value when key matches
            node.value = value;
            return node;
        }
        
        calculateheight(node, aiOperationCount);
        
        if (isRightHeavy(node, aiOperationCount)) {
            if (isLeftHeavy(node.rightChild, aiOperationCount)) {
                node.rightChild = rotateRight(node.rightChild, aiOperationCount);
            }
            node = rotateLeft(node, aiOperationCount);
        } 
        else if (isLeftHeavy(node, aiOperationCount)) {
            if (isRightHeavy(node.leftChild, aiOperationCount)) {
                node.leftChild = rotateLeft(node.leftChild, aiOperationCount);
            }
            node = rotateRight(node, aiOperationCount);
        }

        return node;
    }
}