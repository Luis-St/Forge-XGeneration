package net.luis.nero.api.common.capability;

import java.util.concurrent.Callable;

public class CapabilityFactory<T> implements Callable<T> {

	@Override
	public T call() throws Exception {
		throw new UnsupportedOperationException("Forge doesn't use the CapabilityFactory, therefore it's deprecated, so don't call this methode!");
	}

}
