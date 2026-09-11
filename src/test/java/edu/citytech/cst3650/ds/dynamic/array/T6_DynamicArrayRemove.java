package edu.citytech.cst3650.ds.dynamic.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.ds.model.Option;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;
import edu.cst.csv.function.csv.PopulateDTO;

public class T6_DynamicArrayRemove {

	private String[] symbols;
	private ConceptualList<Option> cList = new DynamicArray<>(Option[]::new);
	ConceptualList<String> cSymbolList = new DynamicArray<String>(String[]::new);

	final String directory = "/Users/idree/Desktop/Downloads/resources-files/put.data.csv";

	@BeforeEach
	void setup() {

		symbols = new String[] { "WGMI", "NUGT", "JNUG", "GDXJ", "RING", "SIL", "SLVP", "STCE", "SGDM", "GDX", "SGDJ",
				"ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM" };

		PopulateDTO.process(Option.class, directory, cList::append, 2);
		
		cSymbolList.append(symbols);
		
	}
	
	/*
	 * Note I have made some changes to this test since this video
	 * so it may be different then
	 */
	//Developer: Mohammad, bahar
	@Test
	void t1() {

		Result addOperationCount = cSymbolList.removeLast();
		Pair<Result, String> actual = cSymbolList.findLast();		
		String expected = "DAPP";
		assertEquals(actual.item2, expected);
		
		System.out.println("addOperationCount: " + addOperationCount);

	}
	
	
	@DisplayName("001B:Remove 1st with more data")
	@Test
	void t2() {

		// O(n)
		Result result = cSymbolList.removeFirst();
		int actual = result.size;
		int expected = 16;

		assertEquals(expected, actual);
	}


	@DisplayName("001C:Remove 1st with more data")
	@Test
	void t3() {

		Result result = cList.removeFirst();
		int actual = result.size;
		int expected = 255;

		assertEquals(expected, actual);
	}

	@DisplayName("001D:Remove last with more data")
	@Test
	void t4() {

		// O(1)
		Result result = cList.removeLast();
		int actual = result.size;
		int expected = 255;

		assertEquals(expected, actual);
	}
}