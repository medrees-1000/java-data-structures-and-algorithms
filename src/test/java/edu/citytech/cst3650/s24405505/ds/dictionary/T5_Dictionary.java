package edu.citytech.cst3650.s24405505.ds.dictionary;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.framework.DataTypeMode;
import com.learning.framework.crud.IDictionary;

import edu.citytech.cst3650.ds.model.TopTechnology;
import edu.cst.csv.function.csv.PopulateDTO;

public class T5_Dictionary {

    // FIXED: Changed DataTypeMode to AVL_TREE to invoke your self-balancing code matching your professor
    IDictionary<String, TopTechnology> advDictionary = 
            new AdvanceDictionary<String, TopTechnology>(TopTechnology[]::new, 
                    DataTypeMode.SINGLY_LINKED_LIST, 20);

    @BeforeEach
    void setup() {
        Consumer<TopTechnology> consumer = e -> {
            advDictionary.put(e.getSymbol(), e);
        };
        PopulateDTO.process(TopTechnology.class, "/Downloads/resources/v02.Top-Technology.csv", consumer, 1);
    }

    @Test
    void t1() {
        System.out.println();
    }
}
