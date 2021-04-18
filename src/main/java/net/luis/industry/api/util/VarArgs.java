package net.luis.industry.api.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VarArgs<T> {
	
	private final List<T> list;
	
	@SafeVarargs
	public VarArgs(T... args) {
		this.list = new ArrayList<T>();
		this.list.addAll(Arrays.asList(args));
	}
	
	public List<T> asList() {
		return this.list;
	}
	
}
