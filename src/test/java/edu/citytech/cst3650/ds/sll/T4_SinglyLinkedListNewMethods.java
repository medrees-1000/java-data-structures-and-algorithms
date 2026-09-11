package edu.citytech.cst3650.ds.sll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.learning.framework.dto.Result;
import com.learning.framework.crud.ConceptualList;
import edu.citytech.cst3650.s24405505.ds.sll.SinglyLinkedList;

public class T4_SinglyLinkedListNewMethods {

    private String[] symbols = null;
    private ConceptualList<String> cList = null;

    @BeforeEach
    void setup() {
        // Using the exact symbols from your T3 file
    	symbols = new String[] {"WGMI", "NUGT", "JNUG", "GDXJ", "RING", "SIL", "SLVP", "STCE", "SGDM"
    	        , "GDX", "SGDJ", "ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM"};

        cList = new SinglyLinkedList<String>(String[]::new);
        cList.append(symbols);
    }

    // --- insertAt Tests ---

    @SuppressWarnings("deprecation")
	@Test
    void t1_insertAt_Start() {
        Result result = cList.insertAt("START_TOKEN", 0);
        assertEquals(18, cList.length().size);
        assertEquals("START_TOKEN", cList.get(0));
        System.out.println("t1_insertAt_Start: " + result);
    }

    @SuppressWarnings("deprecation")
	@Test
    void t2_insertAt_Middle() {
        // Inserting at index 8 (middle of the 17 symbols)
        Result result = cList.insertAt("MID_TOKEN", 8);
        assertEquals(18, cList.length().size);
        assertEquals("MID_TOKEN", cList.get(8));
        System.out.println("t2_insertAt_Middle: " + result);
    }

    @SuppressWarnings("deprecation")
	@Test
    void t3_insertAt_End() {
        // Inserting at the very end (index 17)
        Result result = cList.insertAt("END_TOKEN", 17);
        assertEquals(18, cList.length().size);
        assertEquals("END_TOKEN", cList.get(17));
        System.out.println("t3_insertAt_End: " + result);
    }

    // --- upsert Tests ---

    @Test
    void t4_upsert_ExistingStart() {
        // "WGMI" is at index 0
        Result result = cList.upsert("WGMI");
        assertEquals(17, cList.length().size);
        assertEquals("Updated existing item", result.message);
        System.out.println("t4_upsert_ExistingStart: " + result);
    }

    @Test
    void t5_upsert_ExistingMiddle() {
        // "SGDM" is in the middle of your array
        Result result = cList.upsert("SGDM");
        assertEquals(17, cList.length().size);
        assertEquals("Updated existing item", result.message);
        System.out.println("t5_upsert_ExistingMiddle: " + result);
    }

    @SuppressWarnings("deprecation")
	@Test
    void t6_upsert_NewAtEnd() {
        Result result = cList.upsert("NEW_TICKER");
        assertEquals(18, cList.length().size);
        assertEquals("Inserted new item", result.message);
        assertEquals("NEW_TICKER", cList.get(17));
        System.out.println("t6_upsert_NewAtEnd: " + result);
    }

    // --- removeAll Tests ---

    @Test
    void t7_removeAll_Null() {
        // Verification of the null requirement to clear all
    	Result result = cList.removeAll((Predicate<String>) null);
        assertEquals(0, cList.length().size);
        System.out.println("t7_removeAll_Null: " + result);
    }

    @Test
    void t8_removeAll_ConditionMatchAll() {
        // Remove everything (every symbol in your list has at least 3 characters)
        Result result = cList.removeAll(s -> s.length() >= 3);
        assertEquals(0, cList.length().size);
        System.out.println("t8_removeAll_ConditionMatchAll: " + result);
    }

    @SuppressWarnings("deprecation")
	@Test
    void t9_removeAll_ConditionMatchSome() {
        // Remove only symbols starting with 'S' (SIL, SLVP, STCE, SGDM, SGDJ, SETM)
        int originalSize = cList.length().size;
        Result result = cList.removeAll(s -> s.startsWith("S"));
        
        assertTrue(cList.length().size < originalSize);
        // "WGMI" should still be at index 0
        assertEquals("WGMI", cList.get(0));
        System.out.println("t9_removeAll_ConditionMatchSome: " + result);
    }
}