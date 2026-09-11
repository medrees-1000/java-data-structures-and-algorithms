package edu.citytech.cst3650.s24405505.ds.bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Result;



// Developer: Mohammad, Bahar
public class T1_BST {
	
	private Float[] numbers;
	ConceptualList<Float> bst = new BST<>(Float[]::new) ;

	@BeforeEach
	void setup() {

	    numbers = new Float[]{300f,400f,200f,100f,350f,600f,175f,10_000f,232f};
	    bst.append(numbers);

	}

	@Test void t1() {
	    Result actual = bst.length();
	    int expected = numbers.length;
	    assertEquals(expected, actual.size);
	}

	@Test void t2() {
	    float result = bst.find(232f).item2[0];
	    float expected = 232f;
	    assertEquals(expected, result);
	}
	
	@Test void t3() {
	    int result = bst.find(235f).item2.length;
	    int expected = 0;
	    assertEquals(expected, result);
	    
	    System.out.println(bst);
	}
	
	@Test void t4() {
        float actual = bst.toArray().item2[numbers.length-1];
        float expected = 10_000f;
        assertEquals(expected, actual);
        System.out.println(bst.toString());
    }
}
