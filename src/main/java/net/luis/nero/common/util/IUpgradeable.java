package net.luis.nero.common.util;

public interface IUpgradeable<T> {
	
	T getNext();
	
	T get();
	
	T getLast();

}
