package edu.citytech.cst3650.s24405505.ds.array;

import java.util.function.Predicate;
import com.learning.framework.INumber;
import com.learning.framework.Instantiate;
import com.learning.framework.crud.AdvanceConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;
import com.learning.framework.dto.Triple;

import edu.citytech.cst3650.s24405505.ds.sort.BinarySearch;

public class DynamicArray<T extends Comparable<T>> extends AdvanceConceptualList<T> {

	private static final long serialVersionUID = 1L;

	protected T[] items;
	private Instantiate<T[]> intFunction;
	private int index;
	private int size = 0;

	// Developer: Mohammad, Bahar
	public DynamicArray(Instantiate<T[]> intFunction) {
		this(intFunction, 10);
	}

	public DynamicArray(Instantiate<T[]> intFunction, int capacity) {
		this.intFunction = intFunction;
		this.items = this.intFunction.apply(capacity);
	}

	@Override
	public Result append(T value) {
		int operationCount = 0;
		size++;

		if (index > items.length - 1) {
			Pair<Long, T[]> pair = ArrayUtil.allocateMoreSpace(intFunction, 5, items);
			items = pair.item2;
			operationCount += pair.item1;
		}

		items[index++] = value;
		Result result = new Result(++operationCount, size, true, "Success");
		return result;
	}

	@Override
	public Result append(@SuppressWarnings("unchecked") T... value) {
		int operationCount = 0;

		for (T t : value) {
			var result = this.append(t);
			operationCount += result.operationCount;
		}

		Result result = new Result(operationCount, size, true, "Success");
		return result;
	}

	@Override
	public Result length() {
		return new Result(1, this.size, true, "Success");
	}

	@Override
	public T get(int index) {
		return items[index];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(this.getClass().getSimpleName());
		builder.append(" size: ");
		builder.append(this.size);
		builder.append(", capacity: ");
		builder.append(this.items.length);
		builder.append(" ");

		// Delegates the array formatting to a utility class
		builder.append(ArrayUtil.toString(items));

		return builder.toString();
	}

	@Override
	public Result removeByIndex(int index) {
		Result result;

		if (index < 0 || index >= this.size) {
			return new Result(1, size, false, "Index out of bounds");
		}

		if (index == this.size - 1) { // O(1) Remove the Last Index
			items[index] = null;
			this.size--;
			this.index--; // Reset pointer so next append fills this spot
			int operationCount = 1;
			result = new Result(operationCount, size, true, "Success!");
		} else {
			// O(n) Logic using ArrayUtil
			Triple<Long, Long, T[]> tripple = ArrayUtil.removeIndexes(intFunction, items, index);
			int operationCount = tripple.item1.intValue();
			this.size = tripple.item2.intValue();
			this.index = this.size; // Sync pointer with new size
			this.items = tripple.item3;
			result = new Result(operationCount, size, true, "Success!");
		}

		return result;
	}

	@Override
	public Result removeFirst() {
		return this.removeByIndex(0);
	}

	@Override
	public Result removeLast() {
		return this.removeByIndex(this.size - 1);
	}

	@Override // O(1)
	public Pair<Result, T> findLast() {
		var result = new Result(1, size, true, "Success!");
		T lastItem = (size > 0) ? this.items[size - 1] : null;
		var pair = new Pair<Result, T>(result, lastItem);
		return pair;
	}

	@Override
	public Pair<Result, T[]> toArray() {
		int newLength = this.size - items.length;
		Pair<Long, T[]> pair = ArrayUtil.allocateMoreSpace(intFunction, newLength, items);

		var pairResult = new Result(pair.item1.intValue(), pair.item2.length, true, "Successful");
		return new Pair<>(pairResult, pair.item2);
	}
	
	@Override
	public Pair<Result, T> findOne(T value) {
	    int operationCount = 0;
	    
	    for (T t : this.items) {
	        if (t == null) continue; // Skip empty slots to prevent NullPointerExceptions

	        operationCount++;
	        if (t.compareTo(value) == 0) {
	            var result = new Result(operationCount, this.size, true, "Success");
	            return new Pair<>(result, t);
	        }
	    }
	    var result = new Result(operationCount, this.size, false, "Item not found");
	    return new Pair<>(result, null);
	}

	@Override // O(n)
	public Pair<Result, T[]> find(T value) {

		int operationCount = 0;

		var da = new DynamicArray<T>(intFunction);

		for (T t : this.items) {
			operationCount++;

			if (t == null)
				continue;

			int status = t.compareTo(value);
			if (status == 0) {
				var result = da.append(t);
				operationCount += result.operationCount;
			}
		}

		var daResult = da.toArray();

		operationCount += daResult.item1.operationCount;
		var result = da.size > 0 ? new Result(operationCount, da.size, true, "Success")
		                         : new Result(operationCount, 0, false, "Failure: Not Found " + value );

		var pair = new Pair<Result, T[]>(result, daResult.item2 );

		return pair;
	}

	@Override // O(n)
	public Pair<Result, Double> max() {

		Double max = Double.MIN_VALUE;
		int operationCount = 0;

		for (int i = 0; i < this.size; i++) {
			operationCount++;
			T currentItem = items[i];

			if (currentItem instanceof Number number) {
				if (number.doubleValue() > max) {
					max = number.doubleValue();
				}
			} else if (currentItem instanceof INumber number) {
				if (number.getNumber() > max) {
					max = number.getNumber();
				}
			}
		}

		Result result = new Result(operationCount, 1, true, "Sucess");
		Pair<Result, Double> pair = new Pair<Result, Double>(result, max);
		return pair;
	}

	@Override // O(n)
	public Pair<Result, Double> min() {
		Double min = Double.MAX_VALUE;
		int operationCount = 0;

		for (int i = 0; i < this.size; i++) {
			operationCount++;
			T currentItem = items[i];

			if (currentItem instanceof Number number) {
				if (number.doubleValue() < min) {
					min = number.doubleValue();
				}
			} else if (currentItem instanceof INumber number) {
				if (number.getNumber() < min) {
					min = number.getNumber();
				}
			}
		}

		Result result = new Result(operationCount, 1, true, "Success");
		return new Pair<>(result, min);
	}

	@Override // O(n)
	public Pair<Result, Double> sum() {
		double total = 0;
		int operationCount = 0;

		for (int i = 0; i < this.size; i++) {
			operationCount++;
			T currentItem = items[i];

			if (currentItem instanceof Number number) {
				total += number.doubleValue();
			} else if (currentItem instanceof INumber number) {
				total += number.getNumber();
			}
		}

		Result result = new Result(operationCount, 1, true, "Success");
		return new Pair<>(result, total);
	}

	@Override // O(n)
	public Pair<Result, Double> average() {
		Pair<Result, Double> sumPair = this.sum();

		double avg = (this.size > 0) ? sumPair.item2 / this.size : 0;

		Result result = new Result(sumPair.item1.operationCount + 1, 1, true, "Success");
		return new Pair<>(result, avg);
	}

	// --- NEWLY IMPLEMENTED METHODS ---

	@Override
	public Result insertAt(T value, int index) {
		int operationCount = 0;

		if (index < 0 || index > this.size) {
			return new Result(1, size, false, "Index out of bounds");
		}

		// Check if we need more space before shifting
		if (this.size >= items.length) {
			Pair<Long, T[]> pair = ArrayUtil.allocateMoreSpace(intFunction, 5, items);
			this.items = pair.item2;
			operationCount += pair.item1;
		}

		// Shift elements to the right to make room
		for (int i = this.size; i > index; i--) {
			items[i] = items[i - 1];
			operationCount++;
		}

		items[index] = value;
		this.size++;
		this.index++; // Maintain the append pointer

		return new Result(++operationCount, size, true, "Success");
	}

//    @Override
//    public Result upsert(T value) {
//        int operationCount = 0;
//        boolean updated = false;
//
//        for (int i = 0; i < this.size; i++) {
//            operationCount++;
//            if (items[i].compareTo(value) == 0) {
//                items[i] = value;
//                updated = true;
//                break;
//            }
//        }
//
//        if (updated) {
//            return new Result(operationCount, size, true, "Updated existing item");
//        } else {
//            Result appendResult = this.append(value);
//            return new Result(operationCount + appendResult.operationCount, size, true, "Inserted new item");
//        }
//    }

	@Override
	public Result removeAll(Predicate<T> filter) {
		int operationCount = 0;

		// Requirement: If parameter is null, remove all items
		if (filter == null) {
			this.items = this.intFunction.apply(10);
			this.size = 0;
			this.index = 0;
			return new Result(1, size, true, "All items removed");
		}

		// Conditional removal
		for (int i = 0; i < this.size; i++) {
			operationCount++;
			if (filter.test(items[i])) {
				this.removeByIndex(i);
				i--; // Adjust index because removeByIndex shifts elements left
			}
		}

		return new Result(operationCount, size, true, "Filtered removal complete");
	}
	
//	@Override
//	public Result upsert(T value) {
//	    int operationCount = 0;
//	    boolean found = false;
//
//	    for (int i = 0; i < items.length; i++) {
//	        if (items[i] != null) {
//	            operationCount++;
//	            int status = items[i].compareTo(value);
//	            if (status == 0) {
//	                items[i] = value; 
//	                found = true;
//	                break; 
//	            }
//	        }
//	    }
//
//	    if (!found) {
//	        var appendResult = this.append(value);
//	        operationCount += appendResult.operationCount;
//	    }
//
//	    var result = new Result(operationCount, this.size, true, "Success");
//	    return result;
//	}
	
	@Override
	public Result upsert(T value) {
	    int operationCount = 0;

	    for (int i = 0; i < this.size; i++) { // Only loop up to 'size', not 'length'
	        operationCount++;
	        if (items[i] != null && items[i].compareTo(value) == 0) {
	            items[i] = value; 
	            return new Result(operationCount, this.size, true, "Update Success");
	        }
	    }

	    // If the loop finishes without finding it, append
	    var appendResult = this.append(value);
	    return new Result(operationCount + appendResult.operationCount, 
	                      this.size, true, "Insert Success");
	}
	
	
	
	@Override
    public Pair<Result, T> findByIndex(int index) {
        T t = this.items[index];

        var result = new Result(1, this.size, true, "Success");
        var pair = new Pair<Result, T>(result, t);
        return pair;
    }

}
