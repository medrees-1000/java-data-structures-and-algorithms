package edu.citytech.cst3650.s24405505.ds.dictionary;

import com.learning.framework.DataTypeMode;
import com.learning.framework.crud.ConceptualList;
import com.learning.framework.dto.Pair;
import com.learning.framework.dto.Result;

import edu.citytech.cst3650.s24405505.ds.array.DynamicArray;
import edu.citytech.cst3650.s24405505.ds.array.SortedDynamicArray;
import edu.citytech.cst3650.s24405505.ds.bst.AVLTree;
import edu.citytech.cst3650.s24405505.ds.bst.BST;
import edu.citytech.cst3650.s24405505.ds.sll.SinglyLinkedList;

public class Bucket<K extends Comparable<K>, V> {

	private ConceptualList<CustomEntry<K,V>> probingObject;

	public Bucket() {
	    probingObject 
	    = new SinglyLinkedList<CustomEntry<K,V>>(CustomEntry[]::new);
	}

	public Bucket(DataTypeMode datatype) {

	    if (datatype == DataTypeMode.SORTED_DYNAMIC_ARRAY) {
	        probingObject 
	        = new SortedDynamicArray<CustomEntry<K,V>>(CustomEntry[]::new);
	    }
	    else if (datatype == DataTypeMode.BINARY_SEARCH_TREE) {
	        probingObject 
	        = new BST<CustomEntry<K,V>>(CustomEntry[]::new);
	    }
	    else if (datatype == DataTypeMode.SINGLY_LINKED_LIST) {
	        probingObject 
	        = new SinglyLinkedList<CustomEntry<K,V>>(CustomEntry[]::new);
	    }
	    else if (datatype == DataTypeMode.DYNAMIC_ARRAY) {
	        probingObject 
	        = new DynamicArray<CustomEntry<K,V>>(CustomEntry[]::new);
	    }
	    else if (datatype == DataTypeMode.AVL_TREE) {
	        probingObject 
	        = new AVLTree<CustomEntry<K,V>>(CustomEntry[]::new);
	    }
	}

	Result add(K key, V value) {

		var entry = new CustomEntry<K, V>(key, value);
		Result result = this.probingObject.upsert(entry);

		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bucket [probingObject=");
		builder.append(probingObject);
		builder.append("]");
		return builder.toString();
	}

	public Pair<Result, V> get(K key) {
	    var entry = new CustomEntry<K, V>(key, null);
	    Pair<Result, CustomEntry<K, V>> pair = probingObject.findOne(entry);
	    if (pair.item2 == null) {
	        return new Pair<>(pair.item1, null);
	    }
	    CustomEntry<K, V> customEntry = pair.item2;
	    return new Pair<>(pair.item1, customEntry.value);
	}
}