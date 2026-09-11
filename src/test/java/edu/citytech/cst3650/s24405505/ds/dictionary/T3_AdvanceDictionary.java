package edu.citytech.cst3650.s24405505.ds.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.learning.framework.crud.IDictionary;

import edu.citytech.cst3650.ds.model.TopTechnology;
import edu.citytech.cst3650.s24405505.ds.sll.SinglyLinkedList;
import edu.cst.csv.function.csv.PopulateDTO;

public class T3_AdvanceDictionary {
    
	
	// Developer: Mohammad,  Bahar
    IDictionary<String, TopTechnology> advDictionary = null;
    IDictionary<String, TopTechnology> simpleDictionary = null;

    @BeforeEach
    void setup() {
    	
    	advDictionary = new AdvanceDictionary<String, TopTechnology>(TopTechnology[]::new, 100);
    	simpleDictionary = new SimpleDictionary<String, TopTechnology>(TopTechnology[]::new, 100);
        Consumer<TopTechnology> consumer = e -> {
            advDictionary.put(e.getSymbol(), e);
        };

        PopulateDTO.process(TopTechnology.class, "/Users/idree/Desktop/Downloads/Resources/Top-Technology.csv", consumer , 1);
    }

    @DisplayName("AdvanceDictionary Dictionary : size check ")
    @Test
    void t1() {
        int expected = 539;
        int actual = advDictionary.size().size;
        assertEquals(expected, actual);
        
        System.out.println(advDictionary);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/Top-Technology.csv", numLinesToSkip = 1, delimiter = ',')
    void t2(int rank, String symbol, String companyName, float price) {
        String expected = companyName;
        String actual = advDictionary.get(symbol).item2.getCompanyName();

        assertEquals(expected, actual);
    }
    
    @Test
    void t3() {
        SinglyLinkedList<TopTechnology> sll = new SinglyLinkedList<>(TopTechnology[]::new);

        var simpleDictionary = 
                new SimpleDictionary<String, TopTechnology>(TopTechnology[]::new, 100);

        simpleDictionary.collision((k, v) -> {
            sll.append(v);
        });

        Consumer<TopTechnology> consumer = e -> {
            simpleDictionary.put(e.getSymbol(), e);
        };

        PopulateDTO.process(TopTechnology.class, "/Users/idree/Desktop/Downloads/Resources/Top-Technology.csv"
                , consumer, 1);

        int iexpected = 100;
        int iactual = simpleDictionary.size().size;

        assertEquals(iexpected, iactual);
        System.out.println(sll.length());
    }
}