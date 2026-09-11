package edu.citytech.cst3650.s24405505.ds.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.framework.crud.IDictionary;

import edu.citytech.cst3650.ds.model.Stock;

public class T2_AdvanceDictionary {

	private String[] symbols = null;
	IDictionary<Integer, Stock> simpleDictionary = null;

	@BeforeEach
	void setup() {

		symbols = new String[] { "WGMI", "NUGT", "JNUG", "GDXJ", "RING", "SIL", "SLVP", "STCE", "SGDM", "GDX", "SGDJ",
				"ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM" };
		
		simpleDictionary = new AdvanceDictionary<Integer, Stock>(Stock[]::new, 4);

		for (int i = 0; i < symbols.length; i++) {
		    var model = new Stock(i, symbols[i]);
		    var r1 = simpleDictionary.put(model.id(), model);
//		    System.out.println(r1);
//		    System.out.println(model);
		    
		    System.out.println( "\"" + symbols[i] + ", " + i + "\",");
		}

	}



	// Developer: Mohammad Bahar
	@DisplayName("AdvanceDictionary Dictionary : size check")
	@Test
	void t1() {
		int expected = symbols.length;
		int actual = simpleDictionary.size().size;
		assertEquals(expected, actual);
	
	}
	
	
	@DisplayName("AdvanceDictionary Dictionary : get (1) ")
	@Test
	void t2() {
		int expected = symbols.length;
		int actual = simpleDictionary.size().size;
		assertEquals(expected, actual);
	
	}
	
	
	@ParameterizedTest
	@CsvSource({
	    "WGMI, 0",
	    "NUGT, 1",
	    "JNUG, 2",
	    "GDXJ, 3",
	    "RING, 4",
	    "SIL, 5",
	    "SLVP, 6",
	    "STCE, 7",
	    "SGDM, 8",
	    "GDX, 9",
	    "SGDJ, 10",
	    "ETHU, 11",
	    "SILJ, 12",
	    "GOAU, 13",
	    "EETH, 14",
	    "DAPP, 15",
	    "SETM, 16",
	})
	@DisplayName("AdvanceDictionary Dictionary : get (2) ")
	void t3(String expected, int key) {
	    String actual = simpleDictionary.get(key).item2.symbol();
	    assertEquals(expected, actual);
	}

}
