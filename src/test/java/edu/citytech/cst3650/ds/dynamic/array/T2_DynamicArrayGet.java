package edu.citytech.cst3650.ds.dynamic.array;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;

public class T2_DynamicArrayGet {
	
	private String[] symbols;

	@BeforeEach
	void setup() {

	    symbols = new String[] {"WGMI", "NUGT", "JNUG", "GDXJ",     "RING", "SIL",  "SLVP", "STCE", "SGDM"
	        , "GDX", "SGDJ", "ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM"};
	}
    @Test void t1A() {

        ConceptualList<String> cList = new DynamicArray<String>(String[]::new);
        cList.append("A");
        cList.append("B");
        cList.append("C");
        cList.append("D");
        

        String expected = "A";
        @SuppressWarnings("deprecation")
		String actual = cList.get(0);
        assertEquals(expected, actual);

    }

    // Developer : Mohammad, Bahar
    @Test void t1B() {
        ConceptualList<String> cList = new DynamicArray<String>(String[]::new) ;
        cList.append("A","B","C","D");
        String expected = "D";
        @SuppressWarnings("deprecation")
		String actual = cList.get(3);

        assertEquals(expected, actual);
    }

    @Test void t1c() {
        ConceptualList<String> cList = new DynamicArray<String>(String[]::new);
        cList.append(symbols);
        String expected = "SETM";
        @SuppressWarnings("deprecation")
		String actual = cList.get(16);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({ 
    	"1 2 3 4 5 6 7 8 9 A, 5, 6 ",
        "1 2 3 4 5 6 7 8 9 A B, 10, B",
        "1 2 3 4 5 6 7 8 9 A B C, 11, C",
        "1 2 3 4 5 6 7 8 9 A B C D, 12, D",
        "0 1 2 3 4 5 6 7 8 9 A B C D, 5, 5",
    })
    void t2(String digits, int index, String expected ) {

        String[] data = digits.split(" ");
        ConceptualList<String> cList = new DynamicArray<String>(String[]::new, 5) ;
        Result addOperationCount = cList.append(data);
        @SuppressWarnings("deprecation")
		String actual = cList.get(index);
        assertEquals(expected, actual);
        System.out.println("addOperationCount: " + addOperationCount);
    }
    
    @SuppressWarnings("deprecation")
	@Test void t3() {

        ConceptualList<String> cList = new DynamicArray<String>(String[]::new);
        cList.append(symbols);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            cList.get(20);
        });
    
    	}
}