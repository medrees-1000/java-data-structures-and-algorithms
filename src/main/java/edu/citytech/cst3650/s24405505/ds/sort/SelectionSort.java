package edu.citytech.cst3650.s24405505.ds.sort;

import com.learning.framework.dto.Result;

public class SelectionSort { 

	public static <T extends Comparable<T>> Result selectionSort(T[] arr) {
	    return selectionSort(arr, arr.length);
	}
	public static <T extends Comparable<T>> Result selectionSort(T[] arr, int size) {
		int n = size;
		int operationCount = 0;

		for (int i = 0; i < n - 1; i++) {

			// Assume the current position holds
			// the minimum element
			int min_idx = i;

			// Iterate through the unsorted portion
			// to find the actual minimum
			for (int j = i + 1; j < n; j++) {

				operationCount++;

				int status = arr[j].compareTo(arr[min_idx]);
				if (status < 0) {

					// Update min_idx if a smaller element
					// is found
					min_idx = j;
				}
			}

			// Move minimum element to its
			// correct position
			T temp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx] = temp;
		}

		Result result = new Result(operationCount, arr.length, true, "Success!");
		return result;
	}
}