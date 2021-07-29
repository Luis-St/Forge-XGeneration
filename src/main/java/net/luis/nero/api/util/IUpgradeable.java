package net.luis.nero.api.util;

public interface IUpgradeable<T> {
	
	T getNext();
	
	T get();
	
	T getLast();

}
