package edu.citytech.cst3650.ds.dynamic.sorted;

import static edu.citytech.cst3650.s24405505.ds.sort.SelectionSort.*;

import edu.citytech.cst3650.ds.model.MyStock;

public class ViusalSortTest {
	public static void main(String[] args) {
		e0(); 
		e1(); 
		e2(); 
	}

	static <T extends Comparable<T>> void printArray(T[] arr) {
		for (T val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}



	public static void e0() {
		String[] arr = { "g", "a", "d", "z", "f" };

		System.out.print("Original array: ");
		printArray(arr);

		var results = selectionSort(arr);
		System.out.println(results);

		System.out.print("Sorted array: ");
		printArray(arr);
	}

	public static void e1() {
		Integer[] arr = { 64, 25, 12, 22, 11 };

		System.out.print("Original array: ");
		printArray(arr);

		var results = selectionSort(arr);
		System.out.println(results);

		System.out.print("Sorted array: ");
		printArray(arr);
	}

	public static void e2() {
		MyStock[] arr = { new MyStock("ETHD", 46.66f), new MyStock("AGQ", 112f), new MyStock("GGLL", 101.37f),
				new MyStock("GOOX", 71.19f), new MyStock("GDMN", 85.53f), new MyStock("GNUG", 169.67f) };

		System.out.print("Original array: ");
		printArray(arr);

		var results = selectionSort(arr);
		System.out.println(results);

		System.out.print("Sorted array: ");
		printArray(arr);
	}
}
