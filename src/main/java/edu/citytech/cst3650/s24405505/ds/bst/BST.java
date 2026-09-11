package edu.citytech.cst3650.s24405505.ds.bst;

import com.learning.framework.Instantiate;
import static edu.citytech.cst3650.s24405505.ds.bst.NodeHelper.calculateheight;

import java.util.concurrent.atomic.AtomicInteger;

import com.learning.framework.crud.AdvanceConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.array.ArrayUtil;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;

public class BST<T extends Comparable<T>> extends AdvanceConceptualList<T> {

    private static final long serialVersionUID = 1L;
    protected BSTNode<T> root;
    protected int size = 0;
    private Instantiate<T[]> intFunction;

    public BST(Instantiate<T[]> intFunction) {
        this.intFunction = intFunction;
    }
    
    @Override
    public Result append(@SuppressWarnings("unchecked") T... value) {
        int operationCount = 0;

        for (T t : value) {
            var result = this.append(t);
            operationCount += result.operationCount;
        }
        
        Result result = new Result(operationCount, size, true, "Success");
        return result;
    }

    @Override
    public Result append(T value) {
        int operationCount = 0;
        var newNode = new BSTNode<>(value);
        
        if (root == null) {
            root = newNode;
            size++;
            return new Result(++operationCount, size, true, "Success");
        }

        var currentNode = this.root;
        while (true) {
            operationCount++; // Increment count for each comparison
            int status = value.compareTo(currentNode.value);
            
            if (status < 0) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = newNode;
                    size++;
                    break;
                }
                currentNode = currentNode.leftChild;
            } else if (status > 0) {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = newNode;
                    size++;
                    break;
                }
                currentNode = currentNode.rightChild;
            } else if (status == 0) {
                // The Professor's Way: Explicitly throw the exception
                throw new DuplicateEntryException("Duplicates are not allowed!");
            }
        }

        return new Result(++operationCount, size, true, "Success");
    }

    public Result upsert(@SuppressWarnings("unchecked") T... value) {
        int operationCount = 0;

        for (T t : value) {
            var result = this.upsert(t);
            operationCount += result.operationCount;
        }
        
        Result result = new Result(operationCount, size, true, "Success");
        return result;
    }

    @Override
    public Result upsert(T value) {
        int operationCount = 0;
        var newNode = new BSTNode<>(value);
        
        if (root == null) {
            root = newNode;
            size++;
            return new Result(++operationCount, size, true, "Success");
        }

        var currentNode = this.root;
        while (true) {
            operationCount++; 
            int status = value.compareTo(currentNode.value);
            
            if (status < 0) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = newNode;
                    size++;
                    break;
                }
                currentNode = currentNode.leftChild;
            } else if (status > 0) {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = newNode;
                    size++;
                    break;
                }
                currentNode = currentNode.rightChild;
            } else if (status == 0) {
                // Upsert requirement: Replace/overwrite the value when keys match
                currentNode.value = value;
                return new Result(++operationCount, size, true, "Success");
            }
        }

        return new Result(++operationCount, size, true, "Success");
    }
    
    @Override
    public Result length() {
        Result result = new Result(1, size, true, "Success");
        return result;
    }
    
    @Override
    public Pair<Result, T> findOne(T value) {
        Pair<Result, T[]> pair = this.find(value);
        Pair<Result, T> pResult = new Pair<Result, T>(pair.item1, pair.item2[0]);
        return pResult;
    }
    
    @Override
    public Pair<Result, T[]> find(T value) {
        var currentNode = this.root;
        int operationCount = 0;
        T[] data = null; 

        while (currentNode != null) {
            operationCount++;
            int status = value.compareTo(currentNode.value);

            if (status == 0) {
                data = intFunction.apply(1);
                data[0] = currentNode.value;
                break; 
            } else if (status < 0) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }

        // FIX: If data is still null, create an array of size 0
        if (data == null) {
            data = intFunction.apply(0);
        }

        boolean success = (data.length > 0); // Success if we found at least 1 item
        String message = success ? "Success" : "Value not found";
        
        Result result = new Result(operationCount, size, success, message);
        return new Pair<Result, T[]>(result, data);
    }
    
    private void traversePreOrder(BSTNode<T> bstNode, DynamicArray<T> da) {
        if (bstNode == null) {
            return;
        }

        da.append(bstNode.value);
        traversePreOrder(bstNode.leftChild, da);
        traversePreOrder(bstNode.rightChild, da);
    }

    private void traverseInOrder(BSTNode<T> bstNode, DynamicArray<T> da) {
        if (bstNode == null) {
            return;
        }

        traverseInOrder(bstNode.leftChild, da);
        da.append(bstNode.value);
        traverseInOrder(bstNode.rightChild, da);
    }

    @Override
    public String toString() {
        T[] data = this.toArray().item2;
        return ArrayUtil.toString(data);
    }

    @Override
    public Pair<Result, T[]> toArray() {
        DynamicArray<T> da = new DynamicArray<T>(intFunction);
        traverseInOrder(root, da);
        Pair<Result, T[]> pair = da.toArray();
        return pair;
    }
    
    public Pair<Result, Integer> height() {
        AtomicInteger aiOperationCount = new AtomicInteger();
        int height = calculateheight(root, aiOperationCount);
        var result = new Result(aiOperationCount.get(), this.size, true, "Success");
        var pair = new Pair<Result, Integer>(result, height);
        return pair;
    }
    
    @Override
    public Pair<Result, T> getMin() {
        int operationCount = 1;
        return min(root, operationCount);
    }

    private Pair<Result, T> min(BSTNode<T> node, int operationCount) {
        // Base Case: If there is no left child, we found the minimum
        if (node.leftChild == null) {
            Result result = new Result(operationCount, this.size, true, "Success");
            Pair<Result, T> pair = new Pair<Result, T>(result, node.value);
            return pair;
        }

        // Recursive call: move left and increment count
        var pair = this.min(node.leftChild, ++operationCount);
        return pair;
    }
    
    @Override
    public Pair<Result, T> getMax() {
        if (this.root == null) {
            return new Pair<>(new Result(0, 0, false, "Empty Tree"), null);
        }
        int operationCount = 1;
        return max(this.root, operationCount);
    }

    private Pair<Result, T> max(BSTNode<T> node, int operationCount) {
        // Base Case: Far right node is the maximum
        if (node.rightChild == null) {
            Result result = new Result(operationCount, this.size, true, "Success");
            return new Pair<>(result, node.value);
        }
        return max(node.rightChild, ++operationCount);
    }

    public Pair<Result, Double> sum() {
        int[] count = {0}; // Using array to pass by reference in recursion
        double total = calculateSum(this.root, count);
        Result result = new Result(count[0], this.size, true, "Success");
        return new Pair<>(result, total);
    }

    private double calculateSum(BSTNode<T> node, int[] count) {
        if (node == null) return 0;
        count[0]++;
        double value = Double.parseDouble(node.value.toString());
        return value + calculateSum(node.leftChild, count) + calculateSum(node.rightChild, count);
    }

    public Pair<Result, Double> average() {
        var sumPair = this.sum();
        double avg = this.size == 0 ? 0 : sumPair.item2 / this.size;
        return new Pair<>(sumPair.item1, avg);
    }
}















