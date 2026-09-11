package edu.citytech.cst3650.s24405505.ds.dictionary;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.framework.crud.IDictionary;

import edu.citytech.cst3650.ds.model.TopTechnology;
import edu.cst.csv.function.csv.PopulateDTO;

public class T4_AvanceDictionaryPutIfExisty {
	
	// Developer: Mohammad, Bahar
	IDictionary<String, TopTechnology> advDictionary = null;

	@BeforeEach
	void setup() {
	    advDictionary = new AdvanceDictionary<String, TopTechnology>(TopTechnology[]::new, 100);

	    Consumer<TopTechnology> consumer = e -> {
	        advDictionary.put(e.getSymbol(), e);
	    };

	    PopulateDTO.process(TopTechnology.class, "/Users/idree/Desktop/Downloads/Resources/Top-Technology.csv", consumer, 1);
	}

	@Test
	void t1() {
	    TopTechnology msft = new TopTechnology("MSFT", "MSFT-Replacement");
	    
	    advDictionary.put(msft.getSymbol(), msft);

	    //String expected = companyName;
	    String actual = advDictionary.get(msft.getSymbol()).item2.getCompanyName();

	    System.out.println(actual);
	    System.out.println(advDictionary);

	    //assertEquals(expected, actual);
	}
	  
}