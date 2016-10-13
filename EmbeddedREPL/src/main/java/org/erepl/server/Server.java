package org.erepl.server;

import javax.net.ssl.SSLContext;

import org.erepl.server.ssl.SSL;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.ResourceManager;
import io.undertow.websockets.WebSocketConnectionCallback;

public class Server {
	
	private final PathHandler handler;
	
	public Server(int port, SSLContext ctx) {
		if (null == ctx) {
			ctx = SSL.createInsecureContext();
			System.err.println("Using insecure SSL Context");
		}
		
		handler = Handlers.path();
		Undertow.builder()
				.addHttpsListener(port, "localhost", ctx)
				.setHandler(handler)
				.setWorkerThreads(1)
				.setIoThreads(1)
				.build()
				.start();
	}
	
	public void addPath(String path, ResourceManager manager) {
		handler.addPrefixPath(path, Handlers.resource(manager));
	}
	
	public void addPath(String path, WebSocketConnectionCallback callback) {
		handler.addPrefixPath(path, Handlers.websocket(callback));
	}
}