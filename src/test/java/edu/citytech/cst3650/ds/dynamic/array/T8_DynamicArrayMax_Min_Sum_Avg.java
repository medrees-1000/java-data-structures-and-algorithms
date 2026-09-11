package edu.citytech.cst3650.ds.dynamic.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.framework.crud.AdvanceConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.ds.model.Option;
import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;
import edu.cst.csv.function.csv.PopulateDTO;

public class T8_DynamicArrayMax_Min_Sum_Avg {

    private AdvanceConceptualList<Option> cList = new DynamicArray<>(Option[]::new);
    final String directory = "/Users/idree/Desktop/Downloads/resources-files/put.data.csv";

    @BeforeEach
    void setup() {
        PopulateDTO.process(Option.class, directory, cList::append, 2);
    }
    
    // Developer: Mohammad, Bahar;
    
    @Test
    void t1() {
        Double[] values = {100d, 200d, 300d, -7d, 1000d, 17d, 55d};

        AdvanceConceptualList<Double> da = new DynamicArray<>(Double[]::new);
        da.append(values);

        Pair<Result, Double> pair = da.max();

        double expected = 1000d;
        System.out.println(pair);

        double actual = pair.item2;
        assertEquals(expected, actual);
    }

    @Test
    void t2() {

        Pair<Result, Double> pair = cList.max();

        double expected = 514.45;
        System.out.println(pair);

        double actual = pair.item2;
        assertEquals(expected, actual, .001);
    }
    
    
 // --- MIN TESTS ---

    @Test
    void t3() {
        Double[] values = {100d, 200d, 300d, -7d, 1000d, 17d, 55d};

        AdvanceConceptualList<Double> da = new DynamicArray<>(Double[]::new);
        da.append(values);

        Pair<Result, Double> pair = da.min();

        double expected = -7.0;
        System.out.println("t3: " + pair);

        double actual = pair.item2;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void t4() {
        Pair<Result, Double> pair = cList.min();

        // The lowest price in your CSV is 9.55
        double expected = 9.55; 
        System.out.println("t4: " + pair);

        double actual = pair.item2;
        assertEquals(expected, actual, 0.001);
    }

    // --- SUM TESTS ---

    @Test
    void t5() {
        Double[] values = {100d, 200d, 300d};

        AdvanceConceptualList<Double> da = new DynamicArray<>(Double[]::new);
        da.append(values);

        Pair<Result, Double> pair = da.sum();

        double expected = 600.0;
        System.out.println("t5: " + pair);

        double actual = pair.item2;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void t6() {
        Pair<Result, Double> pair = cList.sum();

        // The total sum of the 256 prices in your CSV is 24016.83
        double expected = 24016.83; 
        System.out.println("t6: " + pair);

        double actual = pair.item2;
        assertEquals(expected, actual, 0.01); // Using .01 for large sum precision
    }

    // --- AVERAGE TESTS ---

    @Test
    void t7() {
        Double[] values = {10d, 20d, 30d, 40d};

        AdvanceConceptualList<Double> da = new DynamicArray<>(Double[]::new);
        da.append(values);

        Pair<Result, Double> pair = da.average();

        double expected = 25.0;
        System.out.println("t7: " + pair);

        double actual = pair.item2;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void t8() {
        Pair<Result, Double> pair = cList.average();

        // The average of the prices in your CSV is 93.8157
        double expected = 93.8157; 
        System.out.println("t8: " + pair);

        double actual = pair.item2;
        assertEquals(expected, actual, 0.001);
    }
}