package net.luis.nero.api.util;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.Lists;

public class OptionalArgument {
	
	protected final String argument;
	protected final List<String> arguments;
	
	public OptionalArgument(String argument, String... arguments) {
		this(argument, Lists.newArrayList(arguments));
	}
	
	protected OptionalArgument(String argument, List<String> arguments) {
		this.argument = argument;
		this.arguments = arguments;
	}
	
	public static OptionalArgument of(String argument) {
		List<String> arguments = Lists.newArrayList(System.getProperty("sun.java.command").split(" "));
		arguments.remove(0);
		return new OptionalArgument(argument, arguments);
	}
	
	public boolean isPresent() {
		return this.arguments.contains(this.argument);
	}
	
	public void ifPresent(Consumer<? super String> action) {
		if (this.isPresent()) {
			action.accept(this.argument);
		}
	}
	
}
