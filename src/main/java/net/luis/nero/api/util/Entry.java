package net.luis.nero.api.util;

import java.util.Map;

public class Entry<K, V> implements Map.Entry<K, V> {
	
	private K key;
	private V value;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}

	@Override
	public V setValue(V value) {
		return (this.value = value);
	}
	
}
