package edu.citytech.cst3650.ds.dynamic.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;

public class T4_DynamicArrayRemoveByIndex {

	private String[] letters;

    @BeforeEach
    void setup() {
        letters = new String[] {"A", "B", "C", "D", "E"};
    }

    @Test
    void t1() {
        ConceptualList<String> cList = new DynamicArray<>(String[]::new);
        cList.append(letters);
        cList.removeByIndex(2);

        int actual = cList.length().size;
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void t2() {

        ConceptualList<String> cList = new DynamicArray<>(String[]::new);
        cList.append(letters);
        cList.removeByIndex(4);

        Pair<Result, String> pair = cList.findLast();
        String actual = pair.item2;
        String expected = "D";
        System.out.println(cList);
        assertEquals(expected, actual);

    }

    @Test
    void t3() {

        ConceptualList<String> cList = new DynamicArray<>(String[]::new);
        cList.append(letters);
        cList.removeByIndex(1);

        Pair<Result, String> pair = cList.findLast();
        String actual = pair.item2;
        String expected = "E";
        System.out.println(cList);
        assertEquals(expected, actual);

    }
}
