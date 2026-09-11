package edu.citytech.cst3650.s24405505.ds.sort;

import java.util.function.BiConsumer;

import com.learning.framework.dto.Result;

public class BinarySearch {

	// VERSION 1: For T2_BinarySearch (uses full array length)
    public static <T extends Comparable<T>> Result search(T items[], T searchFor, 
                                                         BiConsumer<Integer, T> biConsumer) {
        return search(items, items.length, searchFor, biConsumer);
    }

    // VERSION 2: For SortedDynamicArray (uses specific size to avoid nulls)
    public static <T extends Comparable<T>> Result search(T items[], int size, T searchFor, 
                                                         BiConsumer<Integer, T> biConsumer) {
        if (items == null || size <= 0) {
            return new Result(0, -1, false, "Array is null or empty");
        }

        int low = 0;
        int high = size - 1; 
        int operationCount = 0;

        while (low <= high) {
            operationCount++;
            int mid = low + (high - low) / 2;

            // Guard against nulls if size is slightly off
            if (items[mid] == null) {
                high = mid - 1;
                continue;
            }

            int comparisonStatus = items[mid].compareTo(searchFor);

            if (comparisonStatus == 0) {
                biConsumer.accept(mid, items[mid]);
                return new Result(operationCount, mid, true, "Success!");
            }

            if (comparisonStatus < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new Result(operationCount, -1, false, "Not found: " + searchFor);
    }
}