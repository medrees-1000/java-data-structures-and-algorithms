package edu.citytech.cst3650.s24405505.ds.dictionary;

public class CustomEntry<K extends Comparable<K>, V> implements Comparable<CustomEntry<K, V>> {

	K key;
	V value;

	public CustomEntry(K key, V value) {
	    this.key = key;
	    this.value = value;
	}

	@Override
	public int compareTo(CustomEntry<K, V> o) {
	    return key.compareTo(o.key);
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("CustomEntry [key=");
	    builder.append(key);
	    builder.append(", value=");
	    builder.append(value);
	    builder.append("]");
	    return builder.toString();
	}

}
