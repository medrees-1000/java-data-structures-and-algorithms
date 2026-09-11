package edu.citytech.cst3650.ds.dynamic.array;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;

public class T1_DynamicArray {
	
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
        

        Result actual = cList.length();
        int expected = 4; // Note: This will likely fail as only 3 items were added
        assertEquals(expected, actual.size);

    }

    // Developer : Mohammad, Bahar
    @Test void t1B() {

        ConceptualList<String> cList = new DynamicArray<String>(String[]::new);
        cList.append("A","B","C","D");
        Result actual = cList.length();
        int expected = 4;
        assertEquals(expected, actual.size);

    }
    
    @Test void t1c() {
        ConceptualList<String> cList = new DynamicArray<String>(String[]::new);
        Result addOperationCount = cList.append(symbols);
        Result actual = cList.length();
        int expected = symbols.length;
        assertEquals(expected, actual.size);
        System.out.println("addOperationCount: " + addOperationCount);
    }

    @ParameterizedTest
    @CsvSource({
        "1 2 3 4 5 6 7 8 9 A, 10",
        "1 2 3 4 5 6 7 8 9 A B, 11",
        "1 2 3 4 5 6 7 8 9 A B C, 12",
        "1 2 3 4 5 6 7 8 9 A B C D, 13",
    })
    void t2(String digits, int expected) {
        String[] data = digits.split(" ");
        ConceptualList<String> cList = new DynamicArray<String>(String[]::new, 12);
        Result addOperationCount = cList.append(data);
        Result actual = cList.length();
        assertEquals(expected, actual.size);
        System.out.println("addOperationCount: " + addOperationCount);
    }
}