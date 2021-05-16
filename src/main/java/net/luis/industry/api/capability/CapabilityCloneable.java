package net.luis.industry.api.capability;

public interface CapabilityCloneable<T> {
	
	T get();
	
	void set(T capability);

}
