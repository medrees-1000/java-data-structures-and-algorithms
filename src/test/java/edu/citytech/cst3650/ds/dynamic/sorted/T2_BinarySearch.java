package edu.citytech.cst3650.ds.dynamic.sorted;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.ds.model.Contract;
import edu.citytech.cst3650.ds.model.MyStock;
import edu.citytech.cst3650.ds.model.Option;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;
import edu.citytech.cst3650.s24405505.ds.sort.BinarySearch;
import edu.cst.csv.function.csv.PopulateDTO;

public class T2_BinarySearch {	
	
	private MyStock[] stocks = null;
	private Contract[] options = null;
	
	final String directory = "/Users/idree/Desktop/Downloads/Resources/put.data.csv";	
	private ConceptualList<Contract> contractList = new DynamicArray<>(Contract[]::new);
	private Contract[] contracts = null;

	@BeforeEach
	void setup() {

	    stocks = new MyStock[] {
	         new MyStock("ETHD", 46.66f)
	        ,new MyStock("AGQ", 112f)
	        ,new MyStock("GGLL", 101.37f)
	        ,new MyStock("GOOX", 71.19f)
	        ,new MyStock("GDMN", 85.53f)
	        ,new MyStock("GNUG", 169.67f)
	    };

	    // Populating the contract list from a directory
	    PopulateDTO.process(Contract.class, directory, contractList::append, 2);
	    
	    // Converting the list to an array and grabbing the second item (item2)
	    options = contractList.toArray().item2;
	    contracts = contractList.toArray().item2;
	}
	
	@Test
	void t1() {
	    // Change (e, i) to (i, e)
	    Result result = BinarySearch.search(stocks, new MyStock("", 46.66f), (i, e) -> {
	        System.out.println("item: " + e + " index: " + i);
	    });

	    System.out.println(result);
	}

	
	void display() {
	    for (int i = 0; i < options.length; i++) {
	        System.out.println("index: " + i + " " + options[i]);
	    }
	}

	@Test
	void t21() {
	    Result result = BinarySearch.search(contracts, new Contract("TSLL251003P00018000"), (e, i) -> {
	        System.out.println("item: " + e + " index: " + i);
	    });

	    System.out.println(result);
	}	
	
}