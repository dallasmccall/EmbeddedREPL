package org.erepl.server;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import io.undertow.io.IoCallback;
import io.undertow.io.Sender;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.resource.Resource;
import io.undertow.util.ETag;
import io.undertow.util.MimeMappings;

public class InternalResource implements Resource {
	private final String path;
	private final URL url;
	
	InternalResource(String path) {
		//TODO - Restrict the path
		this.path = path;
		url = InternalResource.class.getResource(path);
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getLastModified() {
		return new Date(0);
	}

	@Override
	public String getLastModifiedString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ETag getETag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Resource> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType(MimeMappings mimeMappings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void serve(Sender sender, HttpServerExchange exchange, IoCallback completionCallback) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long getContentLength() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCacheKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path getFilePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getResourceManagerRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path getResourceManagerRootPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
