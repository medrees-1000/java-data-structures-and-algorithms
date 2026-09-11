package edu.citytech.cst3650.ds.dynamic.sorted;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.framework.DataTypeMode;
import com.learning.framework.crud.IDictionary;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.ds.model.TopTechnology;
import edu.citytech.cst3650.s24405505.ds.dictionary.AdvanceDictionary;
import edu.cst.csv.function.csv.PopulateDTO;

public class T3_OperationCount {

    IDictionary<String, TopTechnology> advDictionary = 
            new AdvanceDictionary<String, TopTechnology>(TopTechnology[]::new
                , DataTypeMode.SORTED_DYNAMIC_ARRAY, 150);

    @BeforeEach
    void setup() {

        Consumer<TopTechnology> consumer = e -> {
            advDictionary.put(e.getSymbol(), e);
        };

        PopulateDTO.process(TopTechnology.class, "/Users/idree/Desktop/Downloads/Resources/Top-Technology.csv", consumer, 1);
    }

    @ParameterizedTest
    @CsvSource({"NEON", "SVCO", "TTMI", "DASTY", "WIX", "XPER"})
    void t1(String symbol) {

        Pair<Result, TopTechnology> pair = advDictionary.get(symbol);
        System.out.println(pair);

        String actual = pair.item2.getSymbol();
        String expected = symbol;

        assertEquals(expected, actual);
    }
    
}
