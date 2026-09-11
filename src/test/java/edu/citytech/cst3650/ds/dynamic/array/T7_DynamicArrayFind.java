package edu.citytech.cst3650.ds.dynamic.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.ds.model.Option;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;
import edu.cst.csv.function.csv.PopulateDTO;

public class T7_DynamicArrayFind {

	private String[] symbols;
	private ConceptualList<Option> cList = new DynamicArray<>(Option[]::new);
	ConceptualList<String> cSymbolList = new DynamicArray<String>(String[]::new);

	final String directory = "/Users/idree/Desktop/Downloads/resources-files/put.data.csv";

	@BeforeEach
	void setup() {

		symbols = new String[] { "ORCL", "WGMI", "NUGT", "JNUG", "GDXJ", "ORCL", "RING", "SIL", "SLVP", "STCE", "SGDM",
				"GDX", "SGDJ", "ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM", "ORCL" };

		PopulateDTO.process(Option.class, directory, cList::append, 2);
		cSymbolList.append(symbols);
	}

	@ParameterizedTest
	@CsvSource({ "IBM, 0", "ORCL, 3", "EETH, 1", "GOAU, 1", "DAPP, 1", "RING, 1" })
	void t1(String symbol, int expected) {
		Pair<Result, String[]> pair = cSymbolList.find(symbol);
		System.out.println(pair);
		int actual = pair.item2.length;
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/put.data.count.txt", numLinesToSkip = 1, delimiter = '|')
	void t2(String symbol, int expected) {
	    Pair<Result, Option[]> pair = cList.find(new Option(symbol));

	    System.out.println(pair);
	    int actual = pair.item2.length;
	    assertEquals(expected, actual);
	}

}