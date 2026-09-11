package edu.citytech.cst3650.s24405505.ds.bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.framework.dto.Result;



// Developer: Mohammad, Bahar
public class T2_BSTHeight {

    private Float[] dataset1, dataset2;
    BST<Float> bst = new BST<>(Float[]::new);

    @BeforeEach
    public void beforeEach() {
        dataset1 = new Float[]{201f, 105f, 270f, 250f, 300f, 290f, 105f, 63f, 23f, 97f, 199f};
        dataset2 = new Float[]{201f, 105f, 270f, 250f, 300f, 290f, 63f, 23f, 97f, 199f};
    }

    @DisplayName("Testing for Duplicates")
    @Test void t1() {

            Assertions.assertThrows(DuplicateEntryException.class, () -> {
            bst = new BST<>(Float[]::new);
            bst.append(dataset1);
        });

    }
    //Developer: Mohammad, Bahar
    @DisplayName("Height Test for 300")
    @Test void t2() {
    	
        bst = new BST<>(Float[]::new);
        bst.append(dataset2);
        int actual = bst.height().item2;
        int expected = 3;
        assertEquals(expected, actual);

    }
}


