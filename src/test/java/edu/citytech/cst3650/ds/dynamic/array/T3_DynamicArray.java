package edu.citytech.cst3650.ds.dynamic.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.array.ArrayUtil;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;

public class T3_DynamicArray {

	@ParameterizedTest
    //@DisplayName("Testing multiple data from CSV file")
    @CsvFileSource(resources = "/stocks.csv", numLinesToSkip = 0, delimiter = '|')
    void t1(int expected, String stocks) {
        
        ConceptualList<String> stockList = new DynamicArray<String>(String[]::new);
        String[] data = stocks.split(",");
        Result result = stockList.append(data);
        Result actual = stockList.length();
        
        assertEquals(expected, actual.size);     
        System.out.println(result);
    }

	//Developer: Mohammad, Bahar
	@ParameterizedTest
	@CsvFileSource(resources = "/search.by.index.csv"
	    , numLinesToSkip = 1 , delimiter = '|' )
	void t2(String row) {
	    String[] columns = row.split(",");
	    int index = Integer.parseInt(columns[0]);
	    String expected = columns[1];
	    Pair<Long, String[]> pair = ArrayUtil.slice(String[]::new, columns, 2);
	    String[] data = pair.item2;

	    ConceptualList<String> stockList = new DynamicArray<String>(String[]::new) ;
	    stockList.append(data);
	    @SuppressWarnings("deprecation")
		String actual = stockList.get(index);

	    assertEquals(expected, actual);
	    System.out.println(stockList);
	}
}