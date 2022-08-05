package net.luis.nero.common.util;

public interface IUpgradeable<T> {
	
	// TODO: rename: next, current, previous
	
	T getNext();
	
	T get();
	
	T getLast();

}
