package edu.citytech.cst3650.s24405505.ds.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.framework.crud.IDictionary;

import edu.citytech.cst3650.ds.model.Stock;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;
import edu.citytech.cst3650.s24405505.ds.sll.SinglyLinkedList;

public class T1_SimpleDictionary {

	private String[] symbols = null;
	IDictionary<Integer, Stock> simpleDictionary = null;

	@BeforeEach
	void setup() {

		symbols = new String[] { "WGMI", "NUGT", "JNUG", "GDXJ", "RING", "SIL", "SLVP", "STCE", "SGDM", "GDX", "SGDJ",
				"ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM" };


	}

	@DisplayName("Simple Dictionary")
	@Test
	void t1() {

	    simpleDictionary = new SimpleDictionary<Integer, Stock>(Stock[]::new, 20);

	    for (int i = 0; i < symbols.length; i++) {
	        var model = new Stock(i, symbols[i]);
	        simpleDictionary.put(model.id(), model);
	    }

	    int expected = symbols.length;
	    int actual = simpleDictionary.size().size;

	    assertEquals(expected, actual);
	    System.out.println();
	}

	@DisplayName("Simple Dictionary | Collision Test")
	@Test
	void t2() {

	    simpleDictionary = new SimpleDictionary<Integer, Stock>(Stock[]::new, symbols.length - 3);

	    simpleDictionary.collision((k, v) -> {
	        System.out.println("k:" + k + ", v:" + v);
	    });

	    for (int i = 0; i < symbols.length; i++) {
	        var model = new Stock(i, symbols[i]);
	        simpleDictionary.put(model.id(), model);
	    }

	    int expected = symbols.length - 3;
	    int actual = simpleDictionary.size().size;

	    assertEquals(expected, actual);
	    System.out.println();
	} 
	
	@DisplayName("Simple Dictionary | Collision Test | 2")
	@Test
	void t3() {

	    simpleDictionary = new SimpleDictionary<Integer, Stock>(Stock[]::new, symbols.length - 3);

	    SinglyLinkedList<Stock> sll = new SinglyLinkedList<Stock>(Stock[]::new);

	    simpleDictionary.collision((k, v) -> {
	        sll.append(v);
	    });

	    for (int i = 0; i < symbols.length; i++) {
	        var model = new Stock(i, symbols[i]);
	        simpleDictionary.put(model.id(), model);
	    }

	    int expected = 3;
	    int actual = sll.length().size;

	    assertEquals(expected, actual);
	    System.out.println();

	    System.out.println(sll);
	}
	
	@DisplayName("Simple Dictionary | Collision Test | 3")
	@Test
	void t4() {

	    simpleDictionary = new SimpleDictionary<Integer, Stock>(Stock[]::new, symbols.length - 3);

	    DynamicArray<Stock> da = new DynamicArray<Stock>(Stock[]::new);

	    simpleDictionary.collision((k, v) -> {
	        da.append(v);
	    });

	    for (int i = 0; i < symbols.length; i++) {
	        var model = new Stock(i, symbols[i]);
	        simpleDictionary.put(model.id(), model);
	    }

	    int expected = 3;
	    int actual = da.length().size;

	    assertEquals(expected, actual);
	    System.out.println();

	    System.out.println(da);
	}

}
