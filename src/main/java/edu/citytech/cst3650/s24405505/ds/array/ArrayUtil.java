package edu.citytech.cst3650.s24405505.ds.array;

import java.util.function.Consumer;

import com.learning.framework.Instantiate;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Triple;


public class ArrayUtil {
			
		public static <T> Pair<Long, T[]> allocateMoreSpace(Instantiate<T[]> intfunction, int moreSpace, T[] items){
			
			long operationCount = 0;
			int newCount = items.length + moreSpace;
			T[] newItems = intfunction.apply(newCount);
			
			int newLength = moreSpace < 0 ? items.length + moreSpace : items.length;

			for (int i = 0; i < newLength; i++) {
			    newItems[i] = items[i];
			    operationCount++;
			}
			
			Pair<Long, T[]> pair = new Pair<Long, T[]>(operationCount, newItems);
			
			return pair;
		}
		
		public static <T> Pair<Long, T[]> slice(Instantiate<T[]> intfunction, T[] items, int startPosition) {
		    return copyFrom(intfunction, items, startPosition, items.length - 1);
		}
		
		public static <T> Pair<Long, T[]> copyFrom(Instantiate<T[]> intfunction, T[] items, int startPostion, int endPostion){
			
			int newArraySize = endPostion - startPostion + 1;
			T[] newItems = intfunction.apply(newArraySize);
			Long operationCount = (long) 0;
			
			for(int i = startPostion, j = 0; i < endPostion + 1; i++) {
				operationCount++;
				newItems[j++] = items[i];
			}
			
			Pair<Long, T[]> pair = new Pair<Long, T[]>(operationCount, newItems);
			return pair;
		}
		
		
		
		public static <T> Pair<Long, T[]> copyFrom(Instantiate<T[]> intfunction, T[] items, int newSize){
			
			T[] newItems = intfunction.apply(newSize);
			Long operationCount = (long) 0;
			
			for(int i = 0; i < newSize; i++) {
				operationCount++;
				newItems[i] = items[i];
			}
			
			Pair<Long, T[]> pair = new Pair<Long, T[]>(operationCount, newItems);
			return pair;
		}
		
		
		
		public static <T> void displayArray(Class<?> clazz, T[] items, Consumer<String> consumer) {
			String display = "[" + clazz.getSimpleName() + ": ";
			String comma = ", ";
			int operationCount = 0;
			
			int index = 0;
			
			for(T t:items) {
				operationCount++;
				if (operationCount == items.length)
					comma = "";
				display = display + t + "(" + index++ + ")" + comma;
		    }

		    display = display + "] ";
		    consumer.accept(display);
		}
		
		
		
		
		public static <T> void print(Class<?> clazz, T[] items) {
			displayArray(clazz, items, System.out::println);
		}
		
		
		
		
		public static <T> String displayArray(Class<?> clazz, T[] items) {
			String[] results = {""};
			displayArray(clazz, items, e -> {
				results[0] = e;
			});
			return results[0];
		}
		
		/*
		 * Triple 
		 * 
		 * 1. Number of Operation
		 * 2. Data count
		 * 3. The New array 
		 */
		
		
		public static <T> Triple<Long, Long, T[]> removeIndexes(Instantiate<T[]> intfunction, T[] items, int... indexes){
			
			T[] newItems = intfunction.apply(items.length);
			long operationCount =  0;
			
			for(int index : indexes) {
				operationCount++;
				items[index] = null;
			}
			
			long j = 0;
			
			for (int i = 0; i < newItems.length; i++) {
				operationCount++;
				if (items[i] != null) {
					newItems[(int)j++] = items[i];
				}
			}
			
			Triple<Long, Long, T[]> triple = new Triple<Long, Long, T[]>(operationCount, j, newItems);
			
			
			return triple;
		}

		/*
		 * Triple 
		 * 
		 * 1. Number of Operation
		 * 2. Data count
		 * 3. The New array 
		 */


		public static <T> Triple<Long, Long, T[]> splice(Instantiate<T[]> intfunction, T[] items, int start) {
		    
		    T[] newItems = null;
		    long newLength = 0;
		    long operationCount = 0;

		    // Logic for start index exceeding array length
		    if (start > items.length) {
		        newItems = items;
		        operationCount = 1;
		        newLength = items.length;
		        
		    } else if (start < 0) {
		        // Logic for negative start index (slicing from the end)
		        operationCount++;
		        newLength = items.length + start;
		        Pair<Long, T[]> pair = copyFrom(intfunction, items, (int) newLength);
		        operationCount += pair.item1;
		        newItems = pair.item2;

		    } else if (start > 0) {
		        // Logic for standard positive start index
		        Pair<Long, T[]> pair = copyFrom(intfunction, items, start);
		        operationCount += pair.item1;
		        newItems = pair.item2;
		    }
		    else if (start == 0) {
		        newItems = intfunction.apply(0);
		        operationCount++;
		        newLength = 0;
		    }

		    // Return results wrapped in a Triple object
		    Triple<Long, Long, T[]> triple = new Triple<>(operationCount, newLength, newItems);
		    return triple;
		}
		
		public static <T> Triple<Long, Long, T[]> sliceCount(Instantiate<T[]> intfunction, T[] items, int count) {
		    long operationCount = 0;
		    long requestedCount = Math.abs(count);
		    operationCount++;		    
		    if (requestedCount > items.length) {
		        requestedCount = items.length;
		        operationCount++;
		    }

		    Pair<Long, T[]> pair = copyFrom(intfunction, items, (int) requestedCount);
		    operationCount += pair.item1;
		    
		    T[] newItems = pair.item2;
		    long actualDataCount = requestedCount;

		    return new Triple<>(operationCount, actualDataCount, newItems);
		}

		public static <T> String toString(T[] items) {
		    StringBuilder sb = new StringBuilder();
		    int index = 0;

		    String comma = ",";

		    for (T t : items) {

		        if (index == (items.length - 1))
		            comma = "";

		        sb.append(t);
		        sb.append("(");
		        sb.append(index++);
		        sb.append(")");
		        sb.append(comma);

		    }
		    return sb.toString();
		}

}
