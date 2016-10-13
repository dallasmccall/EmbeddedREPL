package org.erepl.server;

import java.io.IOException;

import io.undertow.server.handlers.resource.Resource;
import io.undertow.server.handlers.resource.ResourceChangeListener;
import io.undertow.server.handlers.resource.ResourceManager;

public class InternalResourceManager implements ResourceManager {

	@Override
	public void close() throws IOException {}

	@Override
	public Resource getResource(String path) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isResourceChangeListenerSupported() {
		return false;
	}

	@Override
	public void registerResourceChangeListener(ResourceChangeListener listener) {}

	@Override
	public void removeResourceChangeListener(ResourceChangeListener listener) {}

}
