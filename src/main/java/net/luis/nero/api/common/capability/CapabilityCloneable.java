package net.luis.nero.api.common.capability;

public interface CapabilityCloneable<T> {
	
	T get();
	
	void set(T capability);

}
