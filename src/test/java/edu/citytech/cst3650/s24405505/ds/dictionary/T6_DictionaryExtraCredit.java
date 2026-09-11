package edu.citytech.cst3650.s24405505.ds.dictionary;

import java.util.function.Consumer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

import com.learning.framework.DataTypeMode;
import com.learning.framework.crud.IDictionary;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.ds.model.TopTechnology;
import edu.cst.csv.function.csv.PopulateDTO;

public class T6_DictionaryExtraCredit {

	//Developer: Mohammad,  Bahar
    @ParameterizedTest
    @EnumSource( mode = Mode.INCLUDE, value = DataTypeMode.class,
        names= {"DYNAMIC_ARRAY","SORTED_DYNAMIC_ARRAY","BINARY_SEARCH_TREE","AVL_TREE","SINGLY_LINKED_LIST"})
    void t1(DataTypeMode dataTypeMode) {
        
        IDictionary<String, TopTechnology> advDictionary = 
                new AdvanceDictionary<String, TopTechnology>(TopTechnology[]::new
                    , dataTypeMode, 159);
                
        Consumer<TopTechnology> consumer = e -> {
            advDictionary.put(e.getSymbol(), e);
        };
        PopulateDTO.process(TopTechnology.class, "/Downloads/resources/v02.Top-Technology.csv", consumer, 1);
        
        Pair<Result, TopTechnology> pair = advDictionary.get("AAOI");
        System.out.println("DataType: " + dataTypeMode + " " + pair);
    }
}