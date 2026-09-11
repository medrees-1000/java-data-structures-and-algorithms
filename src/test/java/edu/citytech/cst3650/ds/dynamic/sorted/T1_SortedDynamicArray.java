package edu.citytech.cst3650.ds.dynamic.sorted;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Consumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.framework.DataTypeMode;
import com.learning.framework.crud.ConceptualList;
import com.learning.framework.crud.IDictionary;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.ds.model.TopTechnology;
import edu.citytech.cst3650.s24405505.ds.array.SortedDynamicArray;
import edu.citytech.cst3650.s24405505.ds.dictionary.AdvanceDictionary;
import edu.cst.csv.function.csv.PopulateDTO;

public class T1_SortedDynamicArray {

	private String[] symbols;
	IDictionary<String, TopTechnology> advDictionary = 
		    new AdvanceDictionary<String, TopTechnology>(TopTechnology[]::new
		        , DataTypeMode.SORTED_DYNAMIC_ARRAY, 30);
    //Developer: Mohammad, Bahar
	@BeforeEach
	void setup() {

		symbols = new String[] { "WGMI", "ZLAB", "NUGT", "JNUG", "GDXJ", "RING", "SIL", "SLVP", "STCE", "SGDM", "GDX",
				"SGDJ", "ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM" };

		Consumer<TopTechnology> consumer = e -> {
			advDictionary.put(e.getSymbol(), e);
		};

		PopulateDTO.process(TopTechnology.class, "/Users/idree/Desktop/Downloads/Resources/Top-Technology.csv", consumer, 1);
	}

	@Test
	void t1() {

		ConceptualList<String> cList = new SortedDynamicArray<String>(String[]::new);
		cList.append(symbols);

		Pair<Result, String> result = cList.findByIndex(symbols.length - 1);

		String actual = result.item2;
		String expected = "ZLAB";
		assertEquals(expected, actual);
	}

	@Test
	void t2() {
		// Initializing a SortedDynamicArray for Strings
		SortedDynamicArray<String> cList = new SortedDynamicArray<String>(String[]::new);
		cList.append(symbols);

		cList.append("IBM");

		Pair<Result, String[]> pair = cList.find("xNUGT");
		System.out.println(pair);

		var actual = pair.item1.size;
		var expected = 0;
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource({ "WGMI", "ZLAB", "NUGT", "JNUG", "GDXJ", "RING", "SIL", "SLVP", "STCE", "SGDM", "GDX", "SGDJ", "ETHU",
			"SILJ", "GOAU", "EETH", "DAPP", "SETM" })
	void t3(String symbol) {

		SortedDynamicArray<String> cList = new SortedDynamicArray<String>(String[]::new);
		cList.append(symbols);

		Pair<Result, String[]> pair = cList.find(symbol);
		System.out.println(pair);

		var actual = pair.item2[0];
		var expected = symbol;
		assertEquals(expected, actual);
	}

	static SortedDynamicArray<Integer> sortedDynamicArray = new SortedDynamicArray<Integer>(Integer[]::new);
	static Integer[] items;

	static {
	    items = IntStream.rangeClosed(1, 1000).boxed().toArray(Integer[]::new);
	    sortedDynamicArray.append(items);
	}

	@ParameterizedTest
	@CsvSource({"1000", "500", "999", "7", "111"})
	void t4(Integer expected) {

	    Pair<Result, Integer> pair = sortedDynamicArray.findOne(expected);
	    System.out.println(pair);

	    var actual = pair.item2;

	    assertEquals(expected, actual);
	}
	
	
}