package edu.citytech.cst3650.ds.dynamic.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.learning.framework.dto.Result;
import edu.citytech.cst3650.ds.model.Option;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;
import edu.cst.csv.function.csv.PopulateDTO;

public class T9_DynamicArrayNewMethods {

    private DynamicArray<Option> cList;
    // Using your specific directory path from T8
    final String directory = "/Users/idree/Desktop/Downloads/resources-files/put.data.csv";

    @BeforeEach
    void setup() {
        cList = new DynamicArray<>(Option[]::new);
        PopulateDTO.process(Option.class, directory, cList::append, 2);
    }

    @Test
    void t1_insertAt_Start() {
        Option newOption = new Option("AAAA"); // Should be at index 0
        Result result = cList.insertAt(newOption, 0);
        
        assertEquals(257, cList.length().size);
        assertEquals("AAAA", cList.get(0).toString().contains("AAAA") ? "AAAA" : "");
        
        // Matches your style of showing operation counts
        System.out.println("t1_insertAt_Start: " + result);
    }

    @Test
    void t2_insertAt_Middle() {
        Option midOption = new Option("MID_TICKER");
        int targetIndex = 100;
        Result result = cList.insertAt(midOption, targetIndex);
        
        assertEquals(257, cList.length().size);
        assertEquals(midOption.compareTo(cList.get(targetIndex)), 0);
        
        System.out.println("t2_insertAt_Middle: " + result);
    }

    @Test
    void t3_upsert_UpdateExisting() {
        // "ORCL" is in put.data.csv
        Option orclUpdate = new Option("ORCL"); 
        int originalSize = cList.length().size;
        
        Result result = cList.upsert(orclUpdate);
        
        assertEquals(originalSize, cList.length().size, "Size should not change for update");
        assertEquals("Updated existing item", result.message);
        System.out.println("t3_upsert_Update: " + result);
    }

    @Test
    void t4_upsert_InsertNew() {
        Option brandNew = new Option("NEW_STOCK");
        int expectedSize = cList.length().size + 1;
        
        Result result = cList.upsert(brandNew);
        
        assertEquals(expectedSize, cList.length().size);
        assertEquals("Inserted new item", result.message);
        System.out.println("t4_upsert_Insert: " + result);
    }

    @Test
    void t5_removeAll_NullParameter() {
        // Requirement: If parameter is null, remove all items
    	Result result = cList.removeAll((Predicate<Option>) null);
        
        assertEquals(0, cList.length().size);
        assertEquals("All items removed", result.message);
        System.out.println("t5_removeAll_Null: " + result);
    }

    @Test
    void t6_removeAll_Conditional() {
        // Remove all options where market cap is less than 1,000,000
        // This uses your Option fields from the uploaded CSV
        int originalSize = cList.length().size;
        
        Result result = cList.removeAll(opt -> opt.getNumber() < 50.0); 
        
        assertTrue(cList.length().size < originalSize);
        System.out.println("t6_removeAll_Conditional: " + result);
    }
}
