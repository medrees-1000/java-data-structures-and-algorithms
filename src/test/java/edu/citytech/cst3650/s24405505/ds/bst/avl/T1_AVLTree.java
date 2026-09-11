package edu.citytech.cst3650.s24405505.ds.bst.avl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.bst.AVLTree;



// Developer: Mohammad, Bahar
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("AVLTree Tests")
public class T1_AVLTree {

    private Float[] numbers;
    ConceptualList<Float> bst = new AVLTree<>(Float[]::new);

    @BeforeEach
    void setup() {

    	numbers = new Float[]{100f, 75f, 80f, 79f, 200f, 210f, 150f, 210f, 270f, 290f, 280f};
        bst.append(numbers);

        System.out.println();

    }

    @Test
    void t1() {

        Result actual = bst.length();
        int expected = numbers.length -1;
        assertEquals(expected, actual.size);
    }

    @Test
    void t2() {
        float result = bst.find(100f).item2[0];
        float expected = 100f;
        assertEquals(expected, result);
    }

    @Test
    void t3() {
        int result = bst.find(100f).item2.length;
        int expected = 1;
        assertEquals(expected, result);
        System.out.println(bst.toString());
    }
}
