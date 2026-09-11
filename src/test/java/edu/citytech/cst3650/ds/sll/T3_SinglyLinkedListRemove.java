package edu.citytech.cst3650.ds.sll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.framework.crud.ConceptualList;

import edu.citytech.cst3650.s24405505.ds.sll.SinglyLinkedList;

public class T3_SinglyLinkedListRemove {

    private String[] symbols = null;
    ConceptualList<String> cList = null;

    @BeforeEach
    void setup() {

    	symbols = new String[] {"WGMI", "NUGT", "JNUG", "GDXJ",     "RING", "SIL",  "SLVP", "STCE", "SGDM"
    	        , "GDX", "SGDJ", "ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM"};

        cList = new SinglyLinkedList<String>(String[]::new);
    }

    @DisplayName("Remove 1st Entry")
    @Test
    void t1() {

        cList.append(symbols);

        cList.removeFirst();
        String expected = "NUGT";
        @SuppressWarnings("deprecation")
		String actual = cList.get(0);
        assertEquals(expected, actual);
    }
    
    @DisplayName("Remove 2 Entries")
    @Test
    void t2() {

        cList.append(symbols);

        cList.removeFirst();
        cList.removeFirst();

        String expected = "JNUG";
        @SuppressWarnings("deprecation")
		String actual = cList.get(0);
        assertEquals(expected, actual);
    }

    @DisplayName("Remove All Entries")
    @Test
    void t3() {
        cList.append(symbols);

        for (@SuppressWarnings("unused") String s : symbols) {
            cList.removeFirst();
        }
        int expected = 0;
        int actual = cList.length().size;
        assertEquals(expected, actual);
    }
    
    @DisplayName("Remove the 4 inexd Entry")
    @Test
    void t4() {

        cList.append(symbols);
        cList.removeByIndex(4);
        String expected = "SIL";
        @SuppressWarnings("deprecation")
		String actual = cList.get(4);
        assertEquals(expected, actual);
    }
    
    @DisplayName("Remove the 4 inex Entry, and test size")
    @Test
    void t5() {

        cList.append(symbols);
        cList.removeByIndex(4);
        var expected = symbols.length - 1;
        var actual = cList.length().size;
        assertEquals(expected, actual);
    }
    
    @DisplayName("Remove the 4 inex Entry, and test size")
    @Test
    void t6() {

        cList.append(symbols);
        cList.removeByIndex(0);
        var expected = symbols.length - 1;
        var actual = cList.length().size;
        assertEquals(expected, actual);
    }
    
    @DisplayName("Remove 1st Entry")
    @Test
    void t7() {

        cList.append(symbols);

        cList.removeByIndex(0);
        String expected = "NUGT";
        @SuppressWarnings("deprecation")
		String actual = cList.get(0);
        assertEquals(expected, actual);
    }
    
    @DisplayName("Remove All Entries")
    @Test
    void t8() {

        cList.append(symbols);
        for (int i = symbols.length - 1; i >= 0 ; i--) {
            cList.removeByIndex(i);
        }
        var expected = 0;
        var actual = cList.length().size;
        assertEquals(expected, actual);
    }
    
    @DisplayName("Remove All Entries")
    @Test
    void t9() {
        cList.append(symbols);

        for (@SuppressWarnings("unused") String s : symbols) {
            cList.removeLast();
        }
        int expected = 0;
        int actual = cList.length().size;
        assertEquals(expected, actual);
    }
}

