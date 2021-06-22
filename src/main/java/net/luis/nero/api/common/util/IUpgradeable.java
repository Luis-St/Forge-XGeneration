package net.luis.nero.api.common.util;

public interface IUpgradeable<T> {
	
	T getNext();
	
	T get();
	
	T getLast();

}
