package edu.citytech.cst3650.s24405505.ds.dictionary;

import java.util.function.BiConsumer;

import com.learning.framework.Instantiate;
import com.learning.framework.crud.IDictionary;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

public class SimpleDictionary<K extends Comparable<K>, V extends Comparable<V>> 
    implements IDictionary<K, V> {

    private V[] psuedoBucket;
    private int size = 0;
    private BiConsumer<K, V> biConsumer;

    public SimpleDictionary(Instantiate<V[]> intfunction, int length) {
        this.psuedoBucket = intfunction.apply(length);
    }

    @Override
    public Pair<Result, V> get(K key) {
        return null;
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

        size++;
        int calculatedIndex = key.hashCode() % psuedoBucket.length;

        if (isBucketOccupied(calculatedIndex) && this.biConsumer != null) {
            biConsumer.accept(key, value);
            size--;
        }

        psuedoBucket[calculatedIndex] = value;

        var result = new Result(1, this.size, true, "Success1");

        return result;
    }

    private boolean isBucketOccupied(int calculatedIndex) {
        return psuedoBucket[calculatedIndex] != null;
    }

}
