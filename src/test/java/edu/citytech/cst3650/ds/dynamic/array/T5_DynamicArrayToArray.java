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

public class T5_DynamicArrayToArray {

    private String[] symbols;

    @BeforeEach
    void setup() {
        symbols = new String[] {"WGMI", "NUGT", "JNUG", "GDXJ", "RING", "SIL", 
                                "SLVP", "STCE", "SGDM", "GDX", "SGDJ", "ETHU", "SILJ", 
                                "GOAU", "EETH", "DAPP", "SETM"};
    }

    @DisplayName("Test toArrayMethod")
    @Test void t1A() {
        ConceptualList<String> cList = new DynamicArray<String>(String[]::new);
        cList.append(symbols);

        Pair<Result, String[]> result = cList.toArray();

        int actual = result.item2.length;
        int expected = 17;
        assertEquals(expected, actual);
    }
    //Developer: Mohammad , Bahar;
    final String directory = "/Users/idree/Desktop/Downloads/resources-files/put.data.csv";

    @Test void t2() {
        
        ConceptualList<Option> cList = new DynamicArray<>(Option[]::new);
        PopulateDTO.process(Option.class, directory, cList::append, 2);
        Pair<Result, Option[]> result = cList.toArray();
        
        for(var x : result.item2) {
            System.out.println(x);
        }
        
        int actual = result.item2.length;
        int expected = 256;
        
        assertEquals(expected, actual);
    }
}
