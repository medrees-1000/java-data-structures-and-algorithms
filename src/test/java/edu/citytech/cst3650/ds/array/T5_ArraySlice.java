package edu.citytech.cst3650.ds.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.framework.dto.Triple;

import edu.citytech.cst3650.s24405505.ds.array.ArrayUtil;

public class T5_ArraySlice {

    private String[] symbols;

    @BeforeEach
    void setup() {
        symbols = new String[] {"WGMI", "NUGT", "JNUG", "GDXJ", "RING", "SIL", "SLVP", "STCE", "SGDM",
                "GDX", "SGDJ", "ETHU", "SILJ", "GOAU", "EETH", "DAPP", "SETM"};

        System.out.println("hello");
    }

    // Developer : Mohammad, Bahar
    @ParameterizedTest
    @CsvSource({
        "3, JNUG",
        "1, WGMI",
        "7, SLVP",
        "9999, SETM"
    })
    void t1(int start, String expected) {
        Triple<Long, Long, String[]> triple = ArrayUtil.splice(String[]::new, symbols, start);
        ArrayUtil.print(ArrayUtil.class, triple.item3);
        
        String actual = triple.item3[triple.item3.length - 1]; 
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "3, 3",
        "1, 1",
        "7, 7",
        "9999, 17"
    })
    void t2(int start, int expected) {
        Triple<Long, Long, String[]> triple = ArrayUtil.splice(String[]::new, symbols, start);
        ArrayUtil.print(ArrayUtil.class, triple.item3);
        
        int actual = triple.item3.length;
        assertEquals(expected, actual);
    }
}