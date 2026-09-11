package edu.citytech.cst3650.s24405505.ds.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Summary test by Mohammad, Bahar")
public class T3_BSTMinMaxAvg {

    private Float[] dataset2 = new Float[]{
        201f, 105f, 270f, 250f, 300f, 290f, 63f, 23f, 97f, 199f
    };

    BST<Float> bst = new BST<>(Float[]::new);

    @BeforeEach
    public void beforeEach() {
        bst = new BST<>(Float[]::new);
        bst.append(dataset2);
    }

    @DisplayName("Min Test")
    @Test
    void t1() {
        double actual = bst.getMin().item2;
        double expected = 23;
        assertEquals(expected, actual);
    }
    
    @DisplayName("Max Test")
    @Test
    void t2() {
        double actual = Double.parseDouble(bst.getMax().item2.toString());
        double expected = 300f; 
        assertEquals(expected, actual);
    }

    @DisplayName("Average Test")
    @Test
    void t3() {
        double actual = bst.average().item2;
        double expected = 179.8; // Calculated from dataset2 total / 10
        assertEquals(expected, actual, 0.1); 
    }

    @DisplayName("Sum Test")
    @Test
    void t4() {
        double actual = bst.sum().item2;
        double expected = 1798.0; // Total of all elements in dataset2
        assertEquals(expected, actual);
    }
}

