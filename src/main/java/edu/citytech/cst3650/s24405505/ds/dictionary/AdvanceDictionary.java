package edu.citytech.cst3650.s24405505.ds.dictionary;

import java.util.function.BiConsumer;

import com.learning.framework.DataTypeMode;
import com.learning.framework.Instantiate;
import com.learning.framework.crud.IDictionary;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

public class AdvanceDictionary<K extends Comparable<K>, V extends Comparable<V>> 
    implements IDictionary<K, V> {

	private Bucket<K,V>[] buckets;
	private int size = 0;
	@SuppressWarnings("unused")
	private BiConsumer<K, V> biConsumer;

	private DataTypeMode dataTypeMode = DataTypeMode.SINGLY_LINKED_LIST;

	@SuppressWarnings("unchecked")
	public AdvanceDictionary(Instantiate<V[]> intfunction, int length) {

	    this.buckets = new Bucket[length];

	    System.out.println();
	}

	@SuppressWarnings("unchecked")
	public AdvanceDictionary(Instantiate<V[]> intfunction, DataTypeMode dataTypeMode, int length) {

	    this.buckets = new Bucket[length];
	    this.dataTypeMode = dataTypeMode;

	}

	@Override
	public Pair<Result, V> get(K key) {
	    int calculatedIndex = key.hashCode() % buckets.length;
	    Pair<Result, V> pair = buckets[calculatedIndex].get(key);

	    var results = new Result(pair.item1.operationCount + 1, this.size, true, "Success");
	    var p2 = new Pair<Result, V>(results, pair.item2);
	    return p2;
	}

    @Override
    public Result remove(K key) {
        return null;
    }

    @Override
    public Result removeAll() {
        return null;
    }

    @Override
    public Result size() {
        return new Result(1, size, true, "Success!");
    }

    @Override
    public Result collision(BiConsumer<K, V> biConsumer) {
        this.biConsumer = biConsumer;
        return null;
    }

    @Override
    public Result put(K key, V value) {
        int operationCount = 1; // For hash calculation
        size++;
        int calculatedIndex = key.hashCode() % buckets.length;

        if (this.buckets[calculatedIndex] == null) {
            // PASS the dataTypeMode so the Bucket uses the correct structure
            buckets[calculatedIndex] = new Bucket<>(this.dataTypeMode); 
        }

        var r2 = buckets[calculatedIndex].add(key, value);
        return new Result(operationCount + r2.operationCount, this.size, true, "Success");
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            builder.append("(").append(i).append(") ");
            if (buckets[i] == null) {
                builder.append("null\n");
            } else {
                builder.append(buckets[i].toString()).append("\n");
            }
        }
        return builder.toString();
     }
}
