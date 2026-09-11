package edu.citytech.cst3650.s24405505.ds.array;

import java.util.concurrent.atomic.AtomicReference;

import com.learning.framework.INumber;
import com.learning.framework.Instantiate;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.sort.BinarySearch;
import edu.citytech.cst3650.s24405505.ds.sort.SelectionSort;

//public class DynamicArray<T extends Comparable<T>> extends AdvanceConceptualList<T> {
public class SortedDynamicArray<T extends Comparable<T>> extends DynamicArray<T> {

  private static final long serialVersionUID = 1L;

  public SortedDynamicArray(Instantiate<T[]> intFunction) {
      super(intFunction);
      // TODO Auto-generated constructor stub
  }
  

  
  @Override
  public Result append(T value) {
      var r1 = super.append(value);
      var r2 = SelectionSort.selectionSort(super.items, super.length().size);
      int operationCount = r1.operationCount + r2.operationCount;
  
      Result results = new Result(operationCount, r1.size, true, "Success!");

      return results;
  }
  
  @Override
  public Pair<Result, T> findOne(T value) {
      AtomicReference<T> lookupValue = new AtomicReference<>();
      // Pass current size to avoid NullPointer on empty array slots
      Result result = BinarySearch.search(items, super.length().size, value, (i, e) -> {
          lookupValue.set(e);
      });
      return new Pair<>(result, lookupValue.get());
  }

  @Override
  public Result upsert(T value) {
      AtomicReference<T> lookupValue = new AtomicReference<>();
      int operationCount = 0;
      int currentSize = super.length().size; // Get the actual number of items

      // 1. Search using index first (i), then element (e)
      // 2. Pass currentSize to avoid searching through NULL slots
      Result resultSearch = BinarySearch.search(items, currentSize, value, (i, e) -> {
          items[i] = value;     // Update existing slot
          lookupValue.set(e);   // Mark as found
      });

      operationCount += resultSearch.operationCount;

      // Only append if the search didn't find a match
      if (lookupValue.get() == null) {
          Result resultAppend = this.append(value);
          operationCount += resultAppend.operationCount;
      }

      return new Result(operationCount, super.length().size, true, "Success");
  }
  
  @Override // O(1) - Much faster than a loop!
  public Pair<Result, Double> max() {
      int lastIndex = super.length().size - 1;
      T lastItem = items[lastIndex];
      double value = 0;

      if (lastItem instanceof INumber number) {
          value = number.getNumber();
      }

      return new Pair<>(new Result(1, 1, true, "Success"), value);
  }

  @Override
  public Pair<Result, Double> min() {
      T firstItem = items[0];
      double value = 0;

      if (firstItem instanceof INumber number) {
          value = number.getNumber();
      }

      return new Pair<>(new Result(1, 1, true, "Success"), value);
  }
  
  
}


